package dev.dalol.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.time.Instant;

public class LiveCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String url = event.getOption("url").getAsString();
        String name = event.getOption("name").getAsString();
        String image = event.getOption("image").getAsString();
        if (event.getName().equals("live")) {
            EmbedBuilder embedBuilder = new EmbedBuilder();
            EmbedBuilder builder = new EmbedBuilder();

            embedBuilder.setTitle("Embed gesendet!");
            embedBuilder.setDescription("Das Embed für das Video wurde erfolgreich gesendet!");
            embedBuilder.setColor(0xff8247);

            builder.setAuthor(name + " - Twitch", url);
            builder.addField("Schau dir den Stream an!", "[Klicke hier](" + url + ")", true);
            builder.setImage("https://static-cdn.jtvnw.net/previews-ttv/live_user_" + image + "-1000x600.jpg");
            builder.setFooter("©️ Pinguincrew");
            builder.setColor(0xc533ff);
            builder.setTimestamp(Instant.now());

            Button lwatch = Button.link(url, "Stream anschauen").withEmoji(Emoji.fromFormatted("<:URL:1098645530537627718>"));

            event.replyEmbeds(embedBuilder.build()).setEphemeral(true).queue();
            event.getChannel().sendMessageEmbeds(builder.build()).addContent("<@&1014308234531717230>").setActionRow(lwatch).queue();
        }
    }
}
