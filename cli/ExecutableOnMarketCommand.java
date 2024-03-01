package cli;

import business.Market;

public sealed interface ExecutableOnMarketCommand extends Command permits BuyCommand, SellCommand, ShowOrdersCommand {
    void execute(Market market);
}
