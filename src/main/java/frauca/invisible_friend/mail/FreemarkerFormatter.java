package frauca.invisible_friend.mail;

import frauca.invisible_friend.pairing.Friend;
import frauca.invisible_friend.pairing.Pair;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class FreemarkerFormatter {
    private static final String TEMPLATE_NAME = "mailTemplate";
    private static final Configuration CONFIGURATION = new Configuration(Configuration.VERSION_2_3_31);

    private final List<Friend> friends;
    @SneakyThrows
    public String parse(String templae, Pair pair){
        val freemarker = templateFrom(templae);
        val out = new StringWriter();
        val variables = variables(pair);
        freemarker.process(variables,out);
        return out.toString();
    }


    @SneakyThrows
    private Template templateFrom(String input){
        val reader = new StringReader(input);
        return new Template(TEMPLATE_NAME,reader,CONFIGURATION);
    }


    private final Map<String, Object> variables(Pair pair){
        return Map.of("friends", friends,
                "giver",pair.giver(),
                "receiver",pair.receiver());
    }

}
