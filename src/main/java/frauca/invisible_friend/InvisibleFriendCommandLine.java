package frauca.invisible_friend;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import picocli.CommandLine;

@RequiredArgsConstructor
public class InvisibleFriendCommandLine implements CommandLineRunner, ExitCodeGenerator {
    private final InsivibleFriendCommand command;
    private final CommandLine.IFactory factory;
    private int exitCode= InsivibleFriendCommand.FAILURE;

    @Override
    public void run(String... args) throws Exception {
        exitCode = new CommandLine(command, factory).execute(args);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }
}
