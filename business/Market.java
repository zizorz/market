package business;

import java.util.List;

public interface Market {

    void placeSellOrder(SellOrder sellOrder);

    void placeBuyOrder(BuyOrder buyOrder);

    List<BuyOrder> getBuyOrders(String product);

    List<SellOrder> getSellOrders(String product);
}
