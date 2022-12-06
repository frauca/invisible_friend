package frauca.invisible_friend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;

@SpringBootApplication(exclude = FreeMarkerAutoConfiguration.class)
@Slf4j
public class InvisibleFriendApplication{

	public static void main(String[] args) {
		SpringApplication.run(InvisibleFriendApplication.class, args);
	}
}
