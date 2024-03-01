package cli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cli {

    private final BufferedReader reader;

    public Cli() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public Command readCommand() throws IOException {
        System.out.println("Enter a command.");
        var line = reader.readLine();
        return CommandParser.parse(line);
    }

}
