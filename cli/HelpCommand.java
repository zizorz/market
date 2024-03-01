package cli;

public final class HelpCommand implements ExecutableCommand {

    HelpCommand() {
    }

    @Override
    public void execute() {
        System.out.println("Available commands:");
        System.out.println("  help - shows this menu");
        System.out.println("  sell <product> <quantity> <pricePerUnit> <seller> - Place a sell order");
        System.out.println("  buy <product> <quantity> <pricePerUnit> <buyer> - Place a buy order");
        System.out.println("  show <product> - Lists all orders for a product");
        System.out.println("  exit");
    }
}
