package cli;

import business.Market;
import business.SellOrder;

import java.math.BigDecimal;

public final class SellCommand implements ExecutableOnMarketCommand {

    private final String product;
    private final int quantity;
    private final BigDecimal pricePerUnit;
    private final String seller;

    SellCommand(String product, int quantity, BigDecimal pricePerUnit, String seller) {
        this.product = product;
        this.quantity = quantity;
        this.pricePerUnit = pricePerUnit;
        this.seller = seller;
    }

    @Override
    public void execute(Market market) {
        var sellOrder = new SellOrder(product, quantity, pricePerUnit, seller);
        market.placeSellOrder(sellOrder);
    }
}
