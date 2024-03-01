package business;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

public abstract class Order {

    protected final String orderId;
    protected final String product;
    protected int quantity;
    protected final BigDecimal pricePerUnit;
    protected final long timestamp;

    public Order(String product, int quantity, BigDecimal pricePerUnit) {
        this.orderId = UUID.randomUUID().toString();
        this.product = product;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.timestamp = System.currentTimeMillis();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(orderId, order.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId);
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPricePerUnit() {
        return pricePerUnit;
    }

    public long getTimestamp() {
        return timestamp;
    }
}
