package cli;

public sealed interface ExecutableCommand extends Command permits ExitCommand, HelpCommand, UnknownCommand {
    void execute();
}
