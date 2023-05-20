package dev.dalol.Embeds;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.Instant;

public class Info extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContentStripped().equals("!info")) {
            if (event.getMember().hasPermission(Permission.ADMINISTRATOR)) {
                EmbedBuilder builder = new EmbedBuilder();

                builder.setTitle("Rollen Information");
                builder.setDescription("> damit ihr natürlich wisst, welche Rollen was bedeuten oder auch wie man sie bekommt aktuell sind aber nur zur Information, die Level Rollen verfügbar. Vielleicht werden wir in zukunft Rollen hinzufügen aber kommt eher drauf an wie das Feedback vom Level System ist oder auch ansich Teamrollen die aber ja natürlich selbsterklärend wären.");
                builder.addField("<:icon_whitedot:1093228594974687262> Level Rollen", "<@&1097571136931385395> - **100 Level (MAX Rolle)**\n<@&1072213142647615539> - **Level 50**\n<@&1067801433115730000> - **Level 25**\n<@&1009865817166458931> - **Level 10**\n<@&1009865291209117778> - **Level 5**", false);
                builder.setColor(0x31decf);
                builder.setTimestamp(Instant.now());
                builder.setFooter("©️ Pinguincrew");

                event.getMessage().delete().queue();
                event.getChannel().sendMessageEmbeds(builder.build()).queue();
            }
        }
    }
}
