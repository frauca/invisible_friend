package frauca.invisible_friend.config;

import frauca.invisible_friend.InsivibleFriendCommand;
import frauca.invisible_friend.InvisibleFriendCommandLine;
import frauca.invisible_friend.invisible.InvisibleFriendService;
import frauca.invisible_friend.mail.FreemarkerFormatter;
import frauca.invisible_friend.mail.MailService;
import frauca.invisible_friend.mail.MessageContents;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailSender;
import picocli.CommandLine;

@Configuration
public class InvisibleFriendConfiguration {

    @Bean
    MailService mailService(InvisibleFriendProperties config, MailSender sender){
        val formatter = new FreemarkerFormatter();
        val messageContents = new MessageContents(config.getContent(),formatter);
        return new MailService(sender, messageContents);
    }

    @Bean
    InvisibleFriendService invisibleFriendService(InvisibleFriendProperties config, MailService mail){
        return new InvisibleFriendService(config.getFriends(), mail);
    }

    @Bean
    InvisibleFriendCommandLine commandLineApp(CommandLine.IFactory factory, InvisibleFriendService service){
        val command = new InsivibleFriendCommand(service);
        return new InvisibleFriendCommandLine(command,factory);
    }
}
