package dev.dalol.Embeds;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.Instant;

public class Update extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContentStripped().equals("!update")){
            if (event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
                EmbedBuilder builder = new EmbedBuilder();

                builder.setTitle("<:icon_whitedot:1093228594974687262> Neues Update!");
                builder.addField("<:icon_off:1093229354609291367> Verifizierung Abgeschafft", "> Wir haben nun endgütlig dass Verifizierungssystem __abgeschafft__. Nun wenn ihr die Verifizierung verwendet, werdet ihr eine Fehler Nachricht bekommen.",  false);
                builder.addField("<:icon_twitch:1093222615650406532> Creator Bewerbung Update", "> Wir haben mal eine kleine Änderung an den Creator bewerbungen durchgeführt, was jetzt meiner Meinung nach besser aussieht :)) (<#1009367919504920637>)", false);
                builder.addField("<:icon_whitedot:1093228594974687262> BETA: Level System", "> Wir haben nun ein Level System aber leider nicht von unserem Pinguinbot, wenn dieses Update rauskommt wird trotz dessen immernoch weitere Level Rewards kommen mit vlt. sogar Exklusiven Kanälen usw. Ihr macht einfach im <#1093233486376206367> den </level:873658940360126465> Command nutzen. Ihr könnt mit Nachrichten aufleveln, die Voice XP kommt bald.", false);
                builder.setColor(0x62b58e);
                builder.setFooter("©️ Pinguincrew");
                builder.setTimestamp(Instant.now());
                builder.setImage("https://i.imgur.com/3qEWubT.png");

                event.getMessage().delete().queue();
                event.getChannel().sendMessageEmbeds(builder.build()).addContent("<@&1014311047085174834>").queue();
            }
        }
    }
}
