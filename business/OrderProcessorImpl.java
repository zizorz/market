package business;

import java.math.BigDecimal;
import java.util.*;

public class OrderProcessorImpl implements OrderProcessor {

    private final PriorityQueue<SellOrder> sellOrderQueue;
    private final TreeMap<BuyOrderKey, BuyOrder> buyOrders;

    public OrderProcessorImpl() {
        sellOrderQueue = new PriorityQueue<>(Comparator.comparing((Order o) -> o.pricePerUnit).thenComparingLong(o -> o.timestamp));
        buyOrders = new TreeMap<>();
    }

    @Override
    public List<Transaction> processSellOrder(SellOrder sellOrder) {
        sellOrderQueue.add(sellOrder);
        return match();
    }

    @Override
    public List<Transaction> processBuyOrder(BuyOrder buyOrder) {
        buyOrders.put(BuyOrderKey.from(buyOrder), buyOrder);
        return match();
    }

    @Override
    public List<BuyOrder> listActiveBuyOrders() {
        return new ArrayList<>(buyOrders.values());
    }

    @Override
    public List<SellOrder> listActiveSellOrders() {
        return new ArrayList<>(sellOrderQueue);
    }

    private List<Transaction> match() {
        var transactions = new ArrayList<Transaction>();

        while (!sellOrderQueue.isEmpty()) {
            var sellOrder = sellOrderQueue.peek();
            var buyOrderQueue = getMatchingBuyOrders(sellOrder);

            if (buyOrderQueue.isEmpty()) {
                break;
            }

            var remainingQuantity = sellOrder.getQuantity();

            for (var buyOrder : buyOrderQueue) {
                var transactionQuantity = Math.min(buyOrder.getQuantity(), remainingQuantity);
                remainingQuantity -= transactionQuantity;

                var transaction = Transaction.from(sellOrder, buyOrder, transactionQuantity);
                transactions.add(transaction);

                sellOrder.setQuantity(sellOrder.getQuantity() - transactionQuantity);
                buyOrder.setQuantity(buyOrder.getQuantity() - transactionQuantity);

                if (buyOrder.getQuantity() <= 0) {
                    this.buyOrders.remove(BuyOrderKey.from(buyOrder));
                }

                if (sellOrder.getQuantity() <= 0) {
                    sellOrderQueue.poll();
                    break;
                }
            }
        }

        return transactions;
    }

    private Queue<BuyOrder> getMatchingBuyOrders(SellOrder sellOrder) {
        var queue = new PriorityQueue<>(Comparator.comparing(BuyOrder::getTimestamp).thenComparing(BuyOrder::getOrderId));
        var buyOrdersMatchingPrice = buyOrders.tailMap(BuyOrderKey.from(sellOrder.pricePerUnit));

        var requiredQuantity = sellOrder.quantity;
        var takenQuantity = 0;
        var iterator = buyOrdersMatchingPrice.values().iterator();

        while (takenQuantity < requiredQuantity && iterator.hasNext()) {
            var buyOrder = iterator.next();
            queue.add(buyOrder);
            takenQuantity += buyOrder.getQuantity();
        }

        return queue;
    }

    private record BuyOrderKey(BigDecimal pricePerUnit, String orderId) implements Comparable<BuyOrderKey> {

        static BuyOrderKey from(BigDecimal pricePerUnit) {
            return new BuyOrderKey(pricePerUnit, "");
        }

        static BuyOrderKey from(BuyOrder buyOrder) {
            return new BuyOrderKey(buyOrder.getPricePerUnit(), buyOrder.getOrderId());
        }

        @Override
        public int compareTo(BuyOrderKey o) {
            var result = pricePerUnit.compareTo(o.pricePerUnit);
            if (result != 0) {
                return result;
            }
            return orderId.compareTo(o.orderId);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            BuyOrderKey that = (BuyOrderKey) o;
            return Objects.equals(pricePerUnit, that.pricePerUnit) && Objects.equals(orderId, that.orderId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(pricePerUnit, orderId);
        }
    }
}
