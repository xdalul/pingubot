package dev.dalol.Rules;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.Instant;

public class Grundgesetze extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if (event.getMessage().getContentStripped().equals("!grundgesetz")) {
            EmbedBuilder bauplan = new EmbedBuilder();

            bauplan.setDescription("""
                    # <:rules:1098645517401063476> Grundgesetz
                    
                    
                    ## §1 Verhalten

                    * Behandelt jeden Respektvoll, egal wie du ihn / sie magst.
                    * Beleidigungen gehören nicht hier her.
                    * Keine Obszönen Bilder / Videos und Links, wie auch Scam Links
                    * Kein Rassismus, Antisexismus und Sexismus.
                    * Spam ist untersagt.
                    * Haltet euch ebenfalls an die Discord ToS (<https://dis.gd/terms>)


                    ## §2 Sprachkanäle

                    * Keine nervigen geräusche während eines Talks.
                    * Das Soundboard darf nicht gespammt werden.
                    * Channel Hopping (Die ganze zeit von Talk zu Talk springen) ist untersagt.


                    ## §3 Kanalregeln

                    * Haltet euch an die Themen der Kanälen wie z.B. bei Fan-arts natürlich fan arts rein posten.
                    * Im counting.place.here darf die Zahlenreihe nicht extra zerbrochen werden!
                    * Bei Permission Fehlern bitte im support.place.here melden!


                    ## §4 Sonstiges

                    * Beim betreten des Servers, aktzeptiert ihr diesen Regeln zu 100%
                    * **Unwissenheit schützt vor Strafe nicht.**
                    * Alle Regeln haben unterschiedliche Bestrafungen, bei manchen einen Mute, kick und vlt. auch mal Bann
                    * Bei Fehlern oder vergessenen Regeln, das Team drauf hinweisen und nicht ausnutzen.
                    * Habt Spaß ;D""");
            bauplan.setFooter("©️ Pinguincrew");
            bauplan.setColor(0xeb4034);
            bauplan.setTimestamp(Instant.now());

            event.getMessage().delete().queue();
            event.getChannel().sendMessageEmbeds(bauplan.build()).queue();
        }
    }
}