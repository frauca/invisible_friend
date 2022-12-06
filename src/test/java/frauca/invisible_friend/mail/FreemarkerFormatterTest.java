package frauca.invisible_friend.mail;

import frauca.invisible_friend.pairing.PairSampler;
import lombok.val;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FreemarkerFormatterTest {
    FreemarkerFormatter template = new FreemarkerFormatter();

    @Test
    void simple(){
        val pair = PairSampler.sample();
        val input = "Hello ${giver().name()}";
        val expected = "Hello "+pair.giver().name();

        assertThat(template.parse(input, pair)).isEqualTo(expected);
    }

    @Test
    void mailTest(){
        val pair = PairSampler.sample();
        val input = "Hi ${giver().name()}, you must send and email to ${receiver().name()}. His mail is ${receiver().mail()}";
        val expected = "Hi %s, you must send and email to %s. His mail is %s"
                .formatted(pair.giver().name(),pair.receiver().name(),pair.receiver().mail());

        assertThat(template.parse(input, pair)).isEqualTo(expected);
    }
}