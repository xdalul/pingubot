package dev.dalol.Events;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.components.buttons.Button;

import java.time.Instant;
import java.util.Objects;
public class JoinEvent extends ListenerAdapter {
    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        EmbedBuilder builder = new EmbedBuilder();
        EmbedBuilder embedBuilder = new EmbedBuilder();

        builder.setImage("https://i.imgur.com/Qd0unYe.png");
        builder.setColor(0xFF6BFA);

        embedBuilder.setTitle("Willkommen, " + event.getMember().getEffectiveName() + " in der Pinguincrew!");
        embedBuilder.setDescription("<:stage_hand:1065994539145379901> Wir heißen dich Willkommen und wünschen dir Viel Spaß auf diesem Discord Server!\n");
        embedBuilder.addField("<:icon_sparkle:1075822470315122698> Was du so alles hier machen kannst :)) \n", """
                <:blue_dot:1075822050117177394> Verifiziere dich im <#1058123777587810314>
                <:blue_dot:1075822050117177394>  Nehme an Giveaways teil. (<#1063548901736591462>)
                <:blue_dot:1075822050117177394> Chatte mit anderen Mitgliedern <#1009352452547559507>
                <:blue_dot:1075822050117177394> Spiele Casino <:Okayge:1064551258070982816> (<#1058148134380916746>)
                """, false);
        embedBuilder.addField(":question: Hast du Fragen?", "Dann melde dich doch im <#1055580914131939388>. Dort wird deine Frage wohlmöglich beantwortet.", false);
        embedBuilder.setFooter("©️ Pinguincrew");
        embedBuilder.setTimestamp(Instant.now());
        embedBuilder.setColor(0xFF6BFA);
        embedBuilder.setImage("https://cdn.discordapp.com/attachments/880725442481520660/905443533824077845/auto_faqw.png");

        Button button = Button.link("https://discord.gg/P29wwj6rV7", "Schaue dich um!").withEmoji(Emoji.fromFormatted("<:star:1066001133912457246>"));
        Button button1 = Button.success("fms", "Siehe mehr Features").asDisabled();

        Objects.requireNonNull(event.getUser().openPrivateChannel().flatMap(channel -> channel.sendMessageEmbeds(builder.build(), embedBuilder.build()).addActionRow(button, button1)).complete());
        Objects.requireNonNull(event.getGuild().getTextChannelById("1009437716942958772").sendMessage(event.getMember().getAsMention() + " hat die Pinguincrew betreten.")).queue();
    }
}

