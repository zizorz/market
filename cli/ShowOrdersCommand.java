package cli;

import business.Market;

public final class ShowOrdersCommand implements ExecutableOnMarketCommand {

    private final String product;

    public ShowOrdersCommand(String product) {
        this.product = product;
    }

    @Override
    public void execute(Market market) {
        var sellOrders = market.getSellOrders(product);
        var buyOrders = market.getBuyOrders(product);

        System.out.printf("Sell orders for %s:%n", product);
        sellOrders.forEach(System.out::println);

        System.out.printf("Buy orders for %s:%n", product);
        buyOrders.forEach(System.out::println);
    }

}
