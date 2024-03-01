package business;

import java.math.BigDecimal;

public record Transaction(String product, int quantity, BigDecimal pricePerUnit, String sellOrderId, String seller, String buyOrderId, String buyer) {

    @Override
    public String toString() {
        return "Transaction{" +
                "product='" + product + '\'' +
                ", quantity=" + quantity +
                ", pricePerUnit=" + pricePerUnit +
                ", sellOrderId='" + sellOrderId + '\'' +
                ", seller='" + seller + '\'' +
                ", buyOrderId='" + buyOrderId + '\'' +
                ", buyer='" + buyer + '\'' +
                '}';
    }

    public static Transaction from(SellOrder sellOrder, BuyOrder buyOrder, int quantity) {
        return new Transaction(
                sellOrder.getProduct(),
                quantity,
                sellOrder.getPricePerUnit(),
                sellOrder.getOrderId(),
                sellOrder.getSeller(),
                buyOrder.getOrderId(),
                buyOrder.getBuyer()
        );
    }
}