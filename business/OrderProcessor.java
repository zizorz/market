package business;

import java.util.List;

public interface OrderProcessor {

    List<Transaction> processSellOrder(SellOrder sellOrder);

    List<Transaction> processBuyOrder(BuyOrder buyOrder);

    List<BuyOrder> listActiveBuyOrders();

    List<SellOrder> listActiveSellOrders();
}
