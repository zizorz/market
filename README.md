# Simple Market
This is a simple Java 21 market application that allows users to place buy and sell orders for products. 
The market matches buy and sell orders and completes transactions.

## Usage
```shell
Welcome to the Market. The market is now open.
Enter a command.

> help

Available commands:
  help - shows this menu
  sell <product> <quantity> <pricePerUnit> <seller> - Place a sell order
  buy <product> <quantity> <pricePerUnit> <buyer> - Place a buy order
  show <product> - Lists all orders for a product
  exit
  
Enter a command.
> sell cheese 100 0.7 broker1

Received sell order: SellOrder{orderId='1c042c29-a871-49f8-b9e5-71d288a26ef7', product='cheese', quantity=100, pricePerUnit=0.7, seller='broker1', timestamp=1709281552149}

Enter a command.
> sell cheese 100 0.6 broker2

Received sell order: SellOrder{orderId='d64b4c62-622e-43d7-b28e-945ea7a61014', product='cheese', quantity=100, pricePerUnit=0.6, seller='broker2', timestamp=1709281568865}
Enter a command.
> buy cheese 100 0.7 broker3

Received buy order: BuyOrder{orderId='56e1ee48-1747-4ee0-abef-04c807b1d945', product='cheese', quantity=100, pricePerUnit=0.7, buyer='broker3', timestamp=1709281582110}
Completed 1 transactions.
Transaction{product='cheese', quantity=100, pricePerUnit=0.6, sellOrderId='d64b4c62-622e-43d7-b28e-945ea7a61014', seller='broker2', buyOrderId='56e1ee48-1747-4ee0-abef-04c807b1d945', buyer='broker3'}

Enter a command.
> show cheese

Sell orders for cheese:
SellOrder{orderId='1c042c29-a871-49f8-b9e5-71d288a26ef7', product='cheese', quantity=100, pricePerUnit=0.7, seller='broker1', timestamp=1709281552149}
Buy orders for cheese:

Enter a command.
> buy cheese 100 0.7 broker3

Received buy order: BuyOrder{orderId='9a6d2f98-d108-4f89-b685-0789ae098a38', product='cheese', quantity=100, pricePerUnit=0.7, buyer='broker3', timestamp=1709281616902}
Completed 1 transactions.
Transaction{product='cheese', quantity=100, pricePerUnit=0.7, sellOrderId='1c042c29-a871-49f8-b9e5-71d288a26ef7', seller='broker1', buyOrderId='9a6d2f98-d108-4f89-b685-0789ae098a38', buyer='broker3'}

Enter a command.
> show cheese

Sell orders for cheese:
Buy orders for cheese:

Enter a command.
> exit

Exiting the market...
```
