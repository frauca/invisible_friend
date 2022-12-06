package frauca.invisible_friend;

import frauca.invisible_friend.invisible.ActionType;
import frauca.invisible_friend.invisible.InvisibleFriendService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(description = "Organize the invisible friend givers and receivers by mail. Each giver will receive an emmail explain who must give the gift to.")
@Slf4j
@RequiredArgsConstructor
public class InsivibleFriendCommand implements Callable<Integer> {

    static final Integer SUCCESS=0;
    static final Integer FAILURE=1;
    @CommandLine.Option(names="-t",
            defaultValue = "INVISIBLE",
            description = "Action to perform, default action is ${DEFAULT-VALUE}, and valid values are ${COMPLETION-CANDIDATES}")
    ActionType action;
    private final InvisibleFriendService service;

    @Override
    public Integer call() throws Exception {
        log.info("Execute friend with action {}", action);
        try {
            service.perform(action);
            log.info("Invisible friend finished successfully");
            return SUCCESS;
        }catch (Throwable error){
            log.info("Invisible friend failed. The internal cause was: {}", error.getMessage());
            log.error("More details for the developer that make it",error);
            return FAILURE;
        }
    }
}
