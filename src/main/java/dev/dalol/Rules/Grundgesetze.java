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
            EmbedBuilder bauplan1 = new EmbedBuilder();
            EmbedBuilder bauplan = new EmbedBuilder();

            bauplan1.setColor(0xeb4034);
            bauplan1.setImage("https://i.imgur.com/t2ScHyO.png");

            bauplan.setTitle("<:rules:1098645517401063476> Regelwerk");
            bauplan.setDescription("> Hey, unten bei dem Selektions menü könnt ihr auswählen was ihr für Regeln so sehen wollt bzw. müsst :))\n\n**Achtung: Manche Sektionen sind noch in Arbeit und nur für Teammitglieder verfügbar.**");
            bauplan.setImage("https://cdn.discordapp.com/attachments/906251556637249547/925055440436477982/auto_faqw.png");
            bauplan.setFooter("©️ Pinguincrew");
            bauplan.setColor(0xeb4034);
            bauplan.setTimestamp(Instant.now());

            event.getMessage().delete().queue();
            event.getChannel().sendMessageEmbeds(bauplan1.build(), bauplan.build()).setActionRow(
                    StringSelectMenu.create("regeln")
                            .addOption("§1 Textkanäle", "text", "💬 〣 Wie du dich in Textkanälen verhalten solltest.", Emoji.fromFormatted("<:text:1098642287359176704>"))
                            .addOption("§2 Sprachkanäle", "sprach", "🔊 〣 Wie du dich in Sprachkanälen verhalten solltest.", Emoji.fromFormatted("<:speak:1098643194075422761>"))
                            .addOption("§3 Datenschutz", "data", "⭐ 〣 Um euere Daten zu schützen (IP Adressen, Telefonnummern)", Emoji.fromFormatted("<:vip:1098642282573463632>"))
                            .addOption("§4 Foren", "forum", "🔴 〣 Regeln für die Foren (Aktuell in Arbeit.)", Emoji.fromFormatted("<:forum:1098642289737355355>"))
                            .build()
            ).queue();
        }
    }
    @Override
    public void onStringSelectInteraction(StringSelectInteractionEvent e) {
        switch (e.getValues().get(0)) {
            case "text":
                EmbedBuilder bauplan = new EmbedBuilder();
                EmbedBuilder embedBuilder = new EmbedBuilder();

                embedBuilder.setImage("https://i.imgur.com/EifIcAA.png");
                embedBuilder.setColor(0xeb4034);

                bauplan.setTitle("<:ban:1098645506638499871> | §1 Textkanäle");
                bauplan.setDescription("\n[**§1.1**] Spammen ist nicht erlaubt.\n[**§1.2**] Es ist nicht erlaubt Teammitglieder zu pingen außer es ist ein Notfall wie von Bugs usw.\n[**§1.3**] Beleidigt keinen.\n[**§1.4**] Links sind nicht erlaubt.\n[**§1.5**] Bitte keine Eigenwerbung, also keine DC-Server links oder YT-Kanäle bewerben.\n[**§1.6**] Keine Sexistischen oder Pornografischen Bilder!\n[**§1.7**] Seid kein Krokodil (Krokodil = böse) xD\n[**§1.8**] Bitte schreibt eure Nachrichten in den Richtigen kanal rein also nicht irgendwie im Chat-Support \"erster\" schreiben.\n\nmehr ist noch in arbeit...");
                bauplan.setColor(0xeb4034);
                bauplan.setFooter("©️ Pinguincrew");
                bauplan.setTimestamp(Instant.now());
                bauplan.setImage("https://cdn.discordapp.com/attachments/906251556637249547/925055440436477982/auto_faqw.png");

                e.replyEmbeds(embedBuilder.build(), bauplan.build()).setEphemeral(true).queue();
                break;
            case "sprach":
                EmbedBuilder bauplan2 = new EmbedBuilder();
                EmbedBuilder builder = new EmbedBuilder();

                builder.setImage("https://i.imgur.com/JTs5hOd.png");
                builder.setColor(0xeb4034);

                bauplan2.setTitle("<:ban:1098645506638499871> | §2 Sprachkanäle");
                bauplan2.setDescription("\n[**§2.1**] Keine störenden oder nervigen Sounds / Geräusche.\n[**§2.2**] Mobbt keinen falls jemand die \"Kamera\" an hat.\n[**§2.3**] Im Sprachchat bitte keine Links posten.\n[**§2.4**] Kein/e Kanal Springen machen bzw nicht die ganze zeit in andere Kanäle joinen leaven usw.\n\nmehr ist noch in Arbeit...");
                bauplan2.setFooter("©️ Pinguincrew");
                bauplan2.setTimestamp(Instant.now());
                bauplan2.setColor(0xeb4034);
                bauplan2.setImage("https://cdn.discordapp.com/attachments/906251556637249547/925055440436477982/auto_faqw.png");

                e.replyEmbeds(builder.build(), bauplan2.build()).setEphemeral(true).queue();
                break;
            case "data":
                if (!(e.getMember().hasPermission(Permission.ADMINISTRATOR))) {
                    EmbedBuilder builder2 = new EmbedBuilder();

                    builder2.setTitle(null);
                    builder2.setDescription("<:wrong:1098645494303031469> **Diese Sektion sind nur für Teammitglieder verfügbar.**");
                    builder2.setColor(0xf54242);
                    builder2.setFooter("©️ Pinguincrew");
                    builder2.setTimestamp(Instant.now());

                    e.replyEmbeds(builder2.build()).setEphemeral(true).queue();
                    break;
                } else {
                    EmbedBuilder builder3 = new EmbedBuilder();

                    builder3.setTitle("<:ban:1098645506638499871> | §3 Datenschutz [Nur für Team]");
                    builder3.setDescription("""
                            [**1**] Teilt auf diesem Discord Server keine: IP Adressen, Adressen, Telefonnummern und E-Mail Adressen.
                            [**2**] Wir werden niemals nach solchen Daten fragen.
                            [**3**] Beim Pingu-Bot  werden wir keine Privaten Daten sammeln. Wir zeigen nur an der Konsole an, dass eine Person etwas ausgeführt hat, aber kein Name wird genannt.\s
                            [**4**] Hier dürfen natürlich auch keine Scams oder sonstiges Bewerben werden. Falls eine Person euch per DM Scammen möchte und auf diesem Server ist, dann meldet sowas uns.

                            Mehr kommt noch...""");
                    builder3.setColor(0xf54242);
                    builder3.setFooter("©️ Pinguincrew");
                    builder3.setTimestamp(Instant.now());

                    e.replyEmbeds(builder3.build()).setEphemeral(true).queue();
                    break;
                }
        }
    }
}