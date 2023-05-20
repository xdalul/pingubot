package dev.dalol.Events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.time.Instant;

public class Verify extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContentStripped().equals("!verify")) {
            EmbedBuilder bauplan = new EmbedBuilder();

            bauplan.setTitle("Verifizierung");
            bauplan.setDescription("Wenn du dich verifizierst hast du auch dann zugriff zu allen Textkanälen oder wie auch Sprachkanälen\n\n:question: **Wie Verifiziere ich mich?**\n> Du Verifizierst dich indem du unter dieser Nachricht den Button anklickst damit bekommst du die Verifiziert Rolle und bist Verifiziert ;D");
            bauplan.setFooter("©️ Pinguincrew");
            bauplan.setTimestamp(Instant.now());
            bauplan.setColor(0x42f542);
            bauplan.setImage("https://cdn.discordapp.com/attachments/880725442481520660/905443533824077845/auto_faqw.png");

            Button verify = Button.success("ver", "Verifizieren").withEmoji(Emoji.fromFormatted("✅"));

            event.getChannel().sendMessageEmbeds(bauplan.build()).setActionRow(verify).queue();
        }
    }

    @Override
    public void onButtonInteraction(ButtonInteractionEvent event) {

        if (event.getComponentId().equals("ver")) {
            EmbedBuilder builder = new EmbedBuilder();

            builder.setTitle("`📛` - Information");
            builder.setDescription("> Das Verifizierungssystem wurde abgeschafft. Ab jetzt braucht ihr keine Verifizierung mehr, um auf diesem Discord Server zu chatten. **AUSNAHME |** Bei der Community Safety Funktion.");
            builder.setFooter("©️ Pinguincrew");
            builder.setTimestamp(Instant.now());
            builder.setColor(0xfc4e4e);

            event.replyEmbeds(builder.build()).setEphemeral(true).queue();
        }
    }
}
