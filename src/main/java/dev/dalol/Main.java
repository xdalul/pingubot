package dev.dalol;

import dev.dalol.Commands.LiveCommand;
import dev.dalol.Commands.YouTubeCommand;
import dev.dalol.Embeds.*;
import dev.dalol.Events.JoinEvent;
import dev.dalol.Events.LinkDisabler;
import dev.dalol.Commands.UmfragenCommand;
import dev.dalol.Events.RWGame;
import dev.dalol.Rules.Grundgesetze;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.requests.GatewayIntent;

import static net.dv8tion.jda.api.entities.Activity.ActivityType.STREAMING;
public class Main {
    public static void main(String[] args) {


        Dotenv dotenv = Dotenv.configure()
                .directory("src/main/resources")
                .filename("env")
                .load();

        JDA jda = JDABuilder.createDefault(dotenv.get("TOKEN"))
                .addEventListeners(new Grundgesetze(), new CasinoAnleitung(), new Creator(), new JoinEvent(), new LinkDisabler(), new UmfragenCommand(), new Update(), new Info(), new YouTubeCommand(), new RWGame(), new LiveCommand())
                .setStatus(OnlineStatus.ONLINE)
                .setActivity(Activity.of(STREAMING, "Pinguindave auf YouTube", "https://www.youtube.com/watch?v=oG6sPBBVJvM"))
                .enableIntents(GatewayIntent.MESSAGE_CONTENT)
                .build();

        jda.upsertCommand("umfrage", "📊 〣 Starte eine Umfrage und sehe selbst...")
                .addOption(OptionType.STRING, "frage", "Setze die Frage für die Abstimmung.", true)
                .addOption(OptionType.STRING, "nummer_1", "Setze die Nummer 1 von der Umfrage als das hier:", true)
                .addOption(OptionType.STRING, "nummer_2", "Setze die Nummer 2 von der Umfrage als das hier:", true)
                .addOption(OptionType.STRING, "nummer_3", "Setze die Nummer 3 von der Umfrage als das hier:")
                .addOption(OptionType.STRING, "nummer_4", "Setze die Nummer 4 von der Umfrage als das hier:")
                .addOption(OptionType.STRING, "nummer_5", "Setze die Nummer 5 von der Umfrage als das hier:")
                .queue();

        jda.upsertCommand("youtube", "🔴 〣 Video's ankündigen")
                .addOption(OptionType.STRING, "url", "Welches Video du ankündigen möchtest.", true)
                .addOption(OptionType.STRING, "länge", "Länge des Video's", true)
                .addOption(OptionType.STRING, "name", "Gebe den namen vom Creator an.", true)
                .addOption(OptionType.STRING, "id", "Gebe die Video ID an.", true)
                .queue();

        jda.upsertCommand("live", "🟣 〣 Streams ankündigen")
                .addOption(OptionType.STRING, "url", "Stream-URL", true)
                .addOption(OptionType.STRING, "name", "Gebe den Namen vom Creator an.", true)
                .addOption(OptionType.STRING, "image", "Namen für Creator, LOWERCASE", true)
                .queue();
    }
}