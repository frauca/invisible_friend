package frauca.invisible_friend.config;

import frauca.invisible_friend.pairing.Friend;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties
@Setter
@Getter
public class InvisibleFriendProperties {
    List<Friend> friends;
    MailContentTemplates content;
}
