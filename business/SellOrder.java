package business;

import java.math.BigDecimal;

public class SellOrder extends Order {

    private final String seller;

    public SellOrder(String product, int quantity, BigDecimal pricePerUnit, String seller) {
        super(product, quantity, pricePerUnit);
        this.seller = seller;
    }

    public String getSeller() {
        return seller;
    }

    @Override
    public String toString() {
        return "SellOrder{" +
                "orderId='" + orderId + '\'' +
                ", product='" + product + '\'' +
                ", quantity=" + quantity +
                ", pricePerUnit=" + pricePerUnit +
                ", seller='" + seller + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
