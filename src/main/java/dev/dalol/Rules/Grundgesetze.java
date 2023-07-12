package dev.dalol.Rules;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenu;
import net.dv8tion.jda.api.interactions.components.selections.SelectMenuInteraction;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

import java.time.Instant;

public class Grundgesetze extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContentStripped().equals("!grundgesetz")) {
            EmbedBuilder bauplan = new EmbedBuilder();

            bauplan.setTitle("<:rules:1098645517401063476> Regelwerk");
            bauplan.setDescription("");
            bauplan.setImage("https://cdn.discordapp.com/attachments/906251556637249547/925055440436477982/auto_faqw.png");
            bauplan.setFooter("©️ Pinguincrew");
            bauplan.setColor(0xeb4034);
            bauplan.setTimestamp(Instant.now());

            event.getMessage().delete().queue();
            event.getChannel().sendMessageEmbeds(bauplan.build()).queue();
        }
    }
}