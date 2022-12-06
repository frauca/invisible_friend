package frauca.invisible_friend.mail;

import frauca.invisible_friend.pairing.Pair;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;

import java.io.StringReader;
import java.io.StringWriter;

@RequiredArgsConstructor
public class FreemarkerFormatter {
    private static final String TEMPLATE_NAME = "mailTemplate";
    private static final Configuration CONFIGURATION = new Configuration(Configuration.VERSION_2_3_31);
    @SneakyThrows
    public String parse(String templae, Pair pair){
        val freemarker = templateFrom(templae);
        val out = new StringWriter();
        freemarker.process(pair,out);
        return out.toString();
    }


    @SneakyThrows
    public Template templateFrom(String input){
        val reader = new StringReader(input);

        return new Template(TEMPLATE_NAME,reader,CONFIGURATION);
    }
}
