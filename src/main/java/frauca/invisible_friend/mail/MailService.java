package frauca.invisible_friend.mail;

import frauca.invisible_friend.pairing.Friend;
import frauca.invisible_friend.pairing.Pair;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;


@Slf4j
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender sender;
    private final MessageContents content;


    public void mailTo(Friend friend) {
        log.info("Sending mail to {}", friend.name());
        val pair = new Pair(friend, friend);
        sender.send(messageTo(pair));
    }

    @SneakyThrows
    private MimeMessage messageTo(Pair pair) {
        val message = sender.createMimeMessage();
        val helper = new MimeMessageHelper(message, "utf-8");
        helper.setTo(pair.giver().mail());
        helper.setSubject(content.subhectFor(pair));
        helper.setText(content.bodyFor(pair),true);
        return helper.getMimeMessage();
    }
}
