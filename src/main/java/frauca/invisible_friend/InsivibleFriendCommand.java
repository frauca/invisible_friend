package frauca.invisible_friend;

import frauca.invisible_friend.invisible.ActionType;
import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(description = "Organize the invisible friend givers and receivers by mail. Each giver will receive an emmail explain who must give the gift to.")
@Slf4j
public class InsivibleFriendCommand implements Callable<Integer> {

    static final Integer SUCCESS=0;
    static final Integer FAILURE=1;
    @CommandLine.Option(names="-t",
            defaultValue = "VALIDATION_EMAIL",
            description = "Action to perform, default action is ${DEFAULT-VALUE}, and valid values are ${COMPLETION-CANDIDATES}")
    ActionType action;

    @Override
    public Integer call() throws Exception {
        log.info("Invisible friend with action {} finished successfully", action);
        return SUCCESS;
    }
}
