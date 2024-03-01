import business.MarketFactory;
import cli.*;

import java.io.IOException;

public class Main {


    public static void main(String[] args) throws IOException {
        var market = MarketFactory.createMarket();
        var cli = new Cli();

        System.out.println("Welcome to the Market. The market is now open.");

        for (;;) {
            var command = cli.readCommand();
            switch (command) {
                case ExecutableOnMarketCommand c -> c.execute(market);
                case ExecutableCommand c -> c.execute();
            }
        }
    }

}
