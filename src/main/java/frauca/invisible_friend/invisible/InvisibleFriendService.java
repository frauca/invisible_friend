package frauca.invisible_friend.invisible;

import frauca.invisible_friend.mail.MailService;
import frauca.invisible_friend.pairing.Friend;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class InvisibleFriendService {

    private final List<Friend> friends;
    private final MailService mail;

    public void perform(ActionType action){
        switch (action){
            case VALIDATION -> sendConfirmationMailToAll(friends);
        }
    }

    private void sendConfirmationMailToAll(List<Friend> friends){
        log.info("Send test email to all friends {}", friends.stream().map(Friend::name).toList());
        friends.forEach(mail::mailTo);
    }
}
