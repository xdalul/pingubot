package dev.dalol.Events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

public class LinkDisabler extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContentStripped().startsWith("https://")) {
            if (event.getMember().hasPermission(Permission.MESSAGE_MANAGE)) {
                return;
            } else {
                EmbedBuilder bauplan = new EmbedBuilder();

                bauplan.setTitle(event.getMember().getEffectiveName() + " <:banhammer:1058100743116161026> | Gemuted");
                bauplan.setColor(0xff4c38);
                bauplan.setDescription("Auf diesem Server sind Links nicht erlaubt, vielleicht schau dir die <#1009355902983348315> mal an. \n*fürt zu einem 30 Minuten mute.*");
                bauplan.setFooter("©️ Pinguincrew");
                bauplan.setImage("https://cdn.discordapp.com/attachments/906251556637249547/925055440436477982/auto_faqw.png");
                bauplan.setTimestamp(Instant.now());

                event.getMessage().delete().queue();
                event.getChannel().sendMessageEmbeds(bauplan.build()).queue();
                event.getMember().timeoutFor(30, TimeUnit.MINUTES).queue();
                event.getGuild().getTextChannelById("1009553710520733784").sendMessage("Der nutzer " + event.getMember().getEffectiveName() + " wurde wegen Link-Posting gemutet.").queue();
                System.out.println("[LOG] " + event.getMember().getEffectiveName() + " wurde gemutet wegen Link-Posting.");
            }
        }
    }
}