package business;

import java.math.BigDecimal;

public class BuyOrder extends Order {

    private final String buyer;

    public BuyOrder(String product, int quantity, BigDecimal pricePerUnit, String buyer) {
        super(product, quantity, pricePerUnit);
        this.buyer = buyer;
    }

    public String getBuyer() {
        return buyer;
    }

    @Override
    public String toString() {
        return "BuyOrder{" +
                "orderId='" + orderId + '\'' +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", pricePerUnit=" + pricePerUnit +
                ", buyer='" + buyer + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

}
