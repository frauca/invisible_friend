package frauca.invisible_friend.mail;

import frauca.invisible_friend.config.MailContentTemplates;
import frauca.invisible_friend.pairing.Pair;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MessageContents {
    private final MailContentTemplates templates;
    private final FreemarkerFormatter formatter;

    public String bodyFor(Pair pair){
        return formatter.parse(templates.body(), pair);
    }

    public String subhectFor(Pair pair){
        return formatter.parse(templates.subject(),pair);
    }
}
