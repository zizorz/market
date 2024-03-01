package cli;

public final class ExitCommand implements ExecutableCommand {

    ExitCommand() {
    }

    public void execute() {
        System.out.println("Exiting the market...");
        System.exit(0);
    }
}
