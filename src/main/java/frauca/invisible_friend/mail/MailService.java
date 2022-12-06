package frauca.invisible_friend.mail;

import frauca.invisible_friend.config.MailContentTemplates;
import frauca.invisible_friend.pairing.Friend;
import frauca.invisible_friend.pairing.Pair;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;


@Slf4j
@RequiredArgsConstructor
public class MailService {

    private final MailSender sender;
    private final MessageContents content;


    public void mailTo(Friend friend){
        log.info("Sending mail to {}", friend.name());
        val pair = new Pair(friend,friend);
        sender.send(messageTo(pair));
    }

    private SimpleMailMessage messageTo(Pair pair){
        val message = new SimpleMailMessage();
        message.setTo(pair.giver().mail());
        message.setSubject(content.subhectFor(pair));
        message.setText(content.bodyFor(pair));
        return message;
    }
}
