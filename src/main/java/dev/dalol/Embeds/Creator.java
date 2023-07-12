package dev.dalol.Embeds;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.time.Instant;

public class Creator extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContentStripped().equals("!creator")) {
            EmbedBuilder builder = new EmbedBuilder();

            builder.setTitle("## `\uD83C\uDFAC` | **Creator Rang**");
            builder.setDescription("""
                    > Heyho! Willkommen mal wieder bei den Creator Rang Bewerbungen, diese werden diesmal wieder geändert. Ich red nicht mal so viel und komm sofort zur sache:""");
            builder.addField("<:icon_twitch:1093222615650406532> Twitch", "> 30 Follower \n> ca 2-3 Viewer pro Stream (**Getrackt durch <https://twitchtracker.com/>**)\n> Aktive Streams. (**Ausnahme einer bei Auszeit und Urlaub**)", false);
            builder.addField("<:icon_youtube:1093222617873387621> YouTube", "> 35 Abonnenten\n> ca. 120 Views im Monat (**Getrackt durch <https://socialblade.com/>**)\n> Aktiv Videos machen (**Ausnahme bei einer Auszeit und Urlaub.**)", false);
            builder.addField("<:icon_outage:1093224000437637252> Kleine Information", "> Die Plattform \"Kick\" wird von un s nicht angenommen, wir möchten keine Streamer von einer Plattform die mit Geld von der Casino Plattform Steak bekommt.", false);
            builder.setColor(0xfc4e03);
            builder.setTimestamp(Instant.now());
            builder.setFooter("©️ Pinguincrew");

            Button link = Button.link("https://forms.gle/ZWHCidJ9H2MVugWX9", "Als Creator bewerben").withEmoji(Emoji.fromFormatted("<:icon_link:1093221022389510155>"));

            event.getChannel().sendMessageEmbeds(builder.build()).setActionRow(link).queue();
        }
    }
}