package cli;

import business.BuyOrder;
import business.Market;

import java.math.BigDecimal;

public final class BuyCommand implements ExecutableOnMarketCommand {

    private final String product;
    private final int quantity;
    private final BigDecimal pricePerUnit;
    private final String buyer;

    BuyCommand(String product, int quantity, BigDecimal pricePerUnit, String buyer) {
        this.product = product;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.buyer = buyer;
    }

    @Override
    public void execute(Market market) {
        var buyOrder = new BuyOrder(product, quantity, pricePerUnit, buyer);
        market.placeBuyOrder(buyOrder);
    }
}
