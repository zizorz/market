package business;

public class MarketFactory {

    public static Market createMarket() {
        return new MarketImpl(new OrderProcessorFactoryImpl());
    }

}
