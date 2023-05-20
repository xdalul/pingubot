package dev.dalol.Embeds;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.component.StringSelectInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.selections.StringSelectMenu;

import java.time.Instant;
import java.util.Objects;

public class CasinoAnleitung extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContentStripped().equals("!setup casinohilfe")) {
            if (Objects.requireNonNull(event.getMember()).hasPermission(Permission.ADMINISTRATOR)) {
                EmbedBuilder builder = new EmbedBuilder();

                builder.setTitle("<:dollar:1070779739259809793> Casino Anleitung <:beta_1:1070792716226674688><:beta_2:1070792712669909022>");
                builder.setDescription("""

                        > <:play:1065630918733221918> Moin! Naja es gibt hier im Casino viele Commands die ihr verwenden könnt unten sieht ihr die sogenannte "Drop-down Funktion" womit ihr etwas auswählen könnt welche Funktionen es so gibt.

                        > <:exclemation:1065633463723630594> Diese Funktion ist nicht zu 100% fertig bis jetzt ist es nur eine "Beta-Funktion\"""");
                builder.setColor(0x09cfc);
                builder.setFooter("©️ Pinguincrew");
                builder.setTimestamp(Instant.now());
                builder.setImage("https://cdn.discordapp.com/attachments/880725442481520660/905443533824077845/auto_faqw.png");


                event.getMessage().delete().queue();

                event.getChannel().sendMessageEmbeds(builder.build()).addActionRow(
                        StringSelectMenu.create("casino")
                                .addOption("Standart Commands", "sta", "⚡ 〣 Zeigt dir die Standart Commands vom Casino an.", Emoji.fromFormatted("<:dollar:1070779739259809793>"))
                                .addOption("Spiel Commands", "spi", "🎰 〣 Mit diesen kannst du um dein Geld spielen.", Emoji.fromFormatted("<:star:1066001133912457246>"))
                                .addOption("Sonstige Commands", "sos", "🎟️ 〣 Sonstige Commands die nicht woanders aufgelistet sind.", Emoji.fromFormatted("<:exclemation:1065633463723630594>"))
                                .build()
                ).queue();
            }
        }
    }

    @Override
    public void onStringSelectInteraction(StringSelectInteractionEvent event) {
        switch (event.getValues().get(0)) {
            case "sta":
                EmbedBuilder builder = new EmbedBuilder();

                builder.setTitle("<:dollar:1070779739259809793> Standart Commands");
                builder.setDescription("""
                Hier sind die Standart Commands <:play:1065630918733221918>\s

                > Um geld zu bekommen oder auch vielleicht zu verlieren nutzt ihr `!work`, `!slut` und `!crime` mit `!work` bekommt ihr immer was, aber nicht bei `!slut` und `!crime`. Um was in die Bank oder sonstiges einzuzahlen nutzt du `!dep <anzahl oder "all">` oder `!deposit <anzahl oder "all">` und andersherum `!withdraw <anzahl oder "all">` unteranderem könnt ihr andere leute auf dem Server rauben, aber nur wenn sie das Geld nicht in der Bank haben, unzwar so: `!rob <User (bitte nicht pingen!)>` bald wird es auch einen "Store" geben wo ihr Items kaufen könnt.

                viel spaß :))""");
                builder.setFooter("©️ Pinguincrew");
                builder.setTimestamp(Instant.now());
                builder.setColor(0x09cfc);
                builder.setImage("https://cdn.discordapp.com/attachments/880725442481520660/905443533824077845/auto_faqw.png");

                event.replyEmbeds(builder.build()).setEphemeral(true).queue();
                System.out.println("[LOG] Die CasinoHilfe wurde genutzt");
                break;
            case "spi":
                EmbedBuilder builder1 = new EmbedBuilder();

                builder1.setTitle("<:star:1066001133912457246> Spiel Commands");
                builder1.setDescription("""
                    Hier sind die Commands die ihr beim "Spielen" nutzen könnt <:play:1065630918733221918>

                    > Es gibt viele Commands womit ihr "Spielen" könnt und sogar auch zu zweit spielen könnt ich geb euch hier diesmal eine Auflistung mit ner kleinen Erklärung wie dieser Befehl geht.

                    > `!blackjack <gebot>` - In Blackjack musst du mehr haben als der Dealer (von Zahlen her) und max. wär 21
                    > `!roulette <gebot> <platz>` Roulette ist dieses Ding wo sich dreht und du entweder auf eine Zahl wetten kannst oder auf eine Farbe.
                    > `!russian-roulette` - Selbsterklärend. Dafür sind mind. 2 Spieler benötigt.
                    > `!slot-machine <gebot>` - Selbsterklärend,  und gibt dafür nd viel geld aus ist nähmlich sehr Geld-fressend :))
                    > `!roll` - ka was das ist da wird einfach wie in RL nen Würfel gerollt ohne geld auszugeben\s

                    **Viel spaß beim Spielen :))**""");
                builder1.setFooter("©️ Pinguincrew");
                builder1.setTimestamp(Instant.now());
                builder1.setColor(0x09cfc);
                builder1.setImage("https://cdn.discordapp.com/attachments/880725442481520660/905443533824077845/auto_faqw.png");

                event.replyEmbeds(builder1.build()).setEphemeral(true).queue();
                System.out.println("[LOG] Die CasinoHilfe wurde genutzt");
                break;
            case "sos":
                EmbedBuilder builder2 = new EmbedBuilder();

                builder2.setTitle("<:exclemation:1065633463723630594> Sonstiges");
                builder2.setDescription("""
                    > Naja hier gibts eig nd viel. Ihr könnt auf der Website <https://unbelievaboat.com/commands> euch die anderen Commands ansehen vlt. lernt ihr da etwas neues :)) hehe
                    \uFEFF
                    **Viel Spaß im Casino des weiteren!** <:chattervoid:1014530329614221322>""");
                builder2.setFooter("©️ Pinguincrew");
                builder2.setTimestamp(Instant.now());
                builder2.setColor(0x09cfc);
                builder2.setImage("https://cdn.discordapp.com/attachments/880725442481520660/905443533824077845/auto_faqw.png");

                event.replyEmbeds(builder2.build()).setEphemeral(true).queue();
                System.out.println("[LOG] Die CasinoHilfe wurde genutzt");
                break;
        }
    }
}