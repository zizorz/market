package cli;

public sealed interface Command permits ExecutableCommand, ExecutableOnMarketCommand {
}
