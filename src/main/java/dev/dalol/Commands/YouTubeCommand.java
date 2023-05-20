package dev.dalol.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.Instant;

public class YouTubeCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String url = event.getOption("url").getAsString();
        String länge = event.getOption("länge").getAsString();
        String name = event.getOption("name").getAsString();
        String id = event.getOption("id").getAsString();
        if (event.getName().equals("youtube")) {
            EmbedBuilder embedBuilder = new EmbedBuilder();
            EmbedBuilder builder = new EmbedBuilder();

            embedBuilder.setTitle("Embed gesendet!");
            embedBuilder.setDescription("Das Embed für das Video wurde erfolgreich gesendet!");
            embedBuilder.setColor(0xff8247);

            builder.setAuthor(name + " - YouTube");
            builder.addField("Video", "[Klicke mich für das Video!](" + url + ")", true);
            builder.addField("Länge des Videos", länge, true);
            builder.setImage("https://img.youtube.com/vi/" + id + "/maxresdefault.jpg");
            builder.setFooter("©️ Pinguincrew");
            builder.setColor(0xff4747);
            builder.setTimestamp(Instant.now());

            event.replyEmbeds(embedBuilder.build()).setEphemeral(true).queue();
            event.getChannel().sendMessageEmbeds(builder.build()).addContent("<@&1014308234531717230>").queue();
        }
    }
}
    