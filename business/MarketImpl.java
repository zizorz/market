package business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MarketImpl implements Market {


    private final Map<String, OrderProcessor> matchers;

    private final OrderProcessorFactory orderProcessorFactory;

    public MarketImpl(OrderProcessorFactory orderProcessorFactory) {
        matchers = new HashMap<>();
        this.orderProcessorFactory = orderProcessorFactory;
    }

    @Override
    public void placeSellOrder(SellOrder sellOrder) {
        System.out.println("Received sell order: " + sellOrder);
        var orderMatcher = getMatcher(sellOrder.getProduct());
        var transactions = orderMatcher.processSellOrder(sellOrder);
        handleTransactions(transactions);
    }

    @Override
    public void placeBuyOrder(BuyOrder buyOrder) {
        System.out.println("Received buy order: " + buyOrder);
        var orderMatcher = getMatcher(buyOrder.getProduct());
        var transactions = orderMatcher.processBuyOrder(buyOrder);
        handleTransactions(transactions);
    }

    @Override
    public List<BuyOrder> getBuyOrders(String product) {
        return getMatcher(product).listActiveBuyOrders();
    }

    @Override
    public List<SellOrder> getSellOrders(String product) {
        return getMatcher(product).listActiveSellOrders();
    }

    void handleTransactions(List<Transaction> transactions) {
        if (!transactions.isEmpty()) {
            System.out.printf("Completed %d transactions.%n", transactions.size());
            transactions.forEach(System.out::println);
        }
    }

    private OrderProcessor getMatcher(String product) {
        return matchers.computeIfAbsent(product, ignored -> orderProcessorFactory.create());
    }

}
