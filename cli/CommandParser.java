package cli;

import java.math.BigDecimal;
import java.util.Optional;

public class CommandParser {

    private CommandParser() {
    }

    private static final String SPACE = " ";
    private static final String EMPTY_STRING = "";

    public static Command parse(String line) {
        var tokens = line.split(SPACE);
        var action = Optional.ofNullable(tokens[0]).orElse(EMPTY_STRING);

        try {
            return switch (action) {
                case "exit" -> new ExitCommand();
                case "sell" -> new SellCommand(tokens[1], Integer.parseInt(tokens[2]), new BigDecimal(tokens[3]), tokens[4]);
                case "buy" -> new BuyCommand(tokens[1], Integer.parseInt(tokens[2]), new BigDecimal(tokens[3]), tokens[4]);
                case "show" -> new ShowOrdersCommand(tokens[1]);
                case "help" -> new HelpCommand();
                default -> new UnknownCommand(action);
            };

        } catch (Exception e) {
            return new UnknownCommand(action);
        }
    }
}
