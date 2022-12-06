package frauca.invisible_friend.invisible;

import frauca.invisible_friend.mail.MailService;
import frauca.invisible_friend.pairing.Friend;
import frauca.invisible_friend.pairing.PairsProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
public class InvisibleFriendService {

    private final List<Friend> friends;
    private final MailService mail;
    private final PairsProvider provider;

    public void perform(ActionType action){
        switch (action){
            case VALIDATION -> sendConfirmationMailToAll(friends);
            case INVISIBLE -> invisibleFriend(friends);
        }
    }

    private void invisibleFriend(List<Friend> friends){
        provider.makePairs(friends).forEach(mail::mailTo);
    }

    private void sendConfirmationMailToAll(List<Friend> friends){
        log.info("Send test email to all friends {}", friends.stream().map(Friend::name).toList());
        friends.forEach(mail::mailTo);
    }
}
