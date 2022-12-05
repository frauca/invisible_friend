package frauca.invisible_friend.config;

import frauca.invisible_friend.InsivibleFriendCommand;
import frauca.invisible_friend.InvisibleFriendCommandLine;
import frauca.invisible_friend.invisible.InvisibleFriendService;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import picocli.CommandLine;

@Configuration
public class InvisibleFriendConfiguration {

    @Bean
    InvisibleFriendCommandLine commandLineApp(CommandLine.IFactory factory){
        val command = new InsivibleFriendCommand();
        return new InvisibleFriendCommandLine(command,factory);
    }

    @Bean
    InvisibleFriendService invisibleFriendService(InvisibleFriendProperties config){
        return new InvisibleFriendService(config.getFriends());
    }
}
