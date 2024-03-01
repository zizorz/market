package cli;

public final class UnknownCommand implements ExecutableCommand {
    private final String action;

    UnknownCommand(String action) {
        this.action = action;
    }

    @Override
    public void execute() {
        System.out.println("Unknown command: " + action);
    }
}
