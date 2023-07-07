package dev.dalol.Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.emoji.Emoji;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.Instant;

public class UmfragenCommand extends ListenerAdapter {

    // its a mess ik

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent e) {
        String op1 = e.getOption("nummer_1").getAsString();
        String op2 = e.getOption("nummer_2").getAsString();
        String frage = e.getOption("frage").getAsString();
        if (e.getName().equals("umfrage")) {
            if (e.getMember().hasPermission(Permission.ADMINISTRATOR)) {
                EmbedBuilder builder = new EmbedBuilder();

                builder.setTitle("📊 | Umfrage");
                builder.setDescription("\n> Heyho! Es ist eine neue Umfrage verfügbar! Reagiere unten, um abzustimmen. (*Bitte nur eins Auswählen.*)");
                builder.setAuthor(e.getMember().getEffectiveName(), e.getMember().getAvatarUrl());
                builder.setColor(0xff7530);
                builder.setFooter("©️ Pinguincrew");
                builder.setTimestamp(Instant.now());
                builder.addField("Frage", frage, false);
                if (e.getOption("nummer_3") == null) {
                    if (e.getOption("nummer_4") == null) {
                        if (e.getOption("nummer_5") == null) {
                            builder.addField("Abstimmungen", "> `1️⃣` " + op1 + "\n> `2️⃣` " + op2, false);
                }}}
                if (e.getOption("nummer_4") == null) {
                    if (e.getOption("nummer_3") != null)
                        builder.addField("Abstimmungen", "> `1️⃣` " + op1 + "\n> `2️⃣` " + op2 + "\n> `3️⃣` " + e.getOption("nummer_3").getAsString(), false);
                }
                if (e.getOption("nummer_5") == null) {
                    if (e.getOption("nummer_4") != null)
                        builder.addField("Abstimmungen", "> `1️⃣` " + op1 + "\n> `2️⃣` " + op2 + "\n> `3️⃣` " + e.getOption("nummer_3").getAsString() + "\n> `4️⃣` " + e.getOption("nummer_4").getAsString(), false);
                }
                if (e.getOption("nummer_5") != null) {
                    if (e.getOption("nummer_4") != null)
                        builder.addField("Abstimmungen", "> `1️⃣` " + op1 + "\n> `2️⃣` " + op2 + "\n> `3️⃣` " + e.getOption("nummer_3").getAsString() + "\n> `4️⃣` " + e.getOption("nummer_4").getAsString() + "\n> `5️⃣` " + e.getOption("nummer_5").getAsString(), false);
                }
                e.reply("✅ Umfrage gesendet").setEphemeral(true).queue();

                if (e.getOption("nummer_3") == null) {
                    e.getChannel().sendMessageEmbeds(builder.build()).addContent("<@&1058143914420359188>").queue(message -> {
                        message.addReaction(Emoji.fromFormatted("1️⃣")).queue();
                        message.addReaction(Emoji.fromFormatted("2️⃣")).queue();
                    });
                    return;
                }
                if (e.getOption("nummer_3") != null) {
                    if (e.getOption("nummer_4") == null) {
                        e.getChannel().sendMessageEmbeds(builder.build()).addContent("<@&1058143914420359188>").queue(message -> {
                            message.addReaction(Emoji.fromFormatted("1️⃣")).queue();
                            message.addReaction(Emoji.fromFormatted("2️⃣")).queue();
                            message.addReaction(Emoji.fromFormatted("3️⃣")).queue();
                        });
                        return;
                    }
                }
                if (e.getOption("nummer_4") != null) {
                    if (e.getOption("nummer_5") == null) {
                        e.getChannel().sendMessageEmbeds(builder.build()).addContent("<@&1058143914420359188>").queue(message -> {
                            message.addReaction(Emoji.fromFormatted("1️⃣")).queue();
                            message.addReaction(Emoji.fromFormatted("2️⃣")).queue();
                            message.addReaction(Emoji.fromFormatted("3️⃣")).queue();
                            message.addReaction(Emoji.fromFormatted("4️⃣")).queue();
                        });
                    }
                }
                if (e.getOption("nummer_5") != null) {
                    e.getChannel().sendMessageEmbeds(builder.build()).addContent("<@&1058143914420359188>").queue(message -> {
                        message.addReaction(Emoji.fromFormatted("1️⃣")).queue();
                        message.addReaction(Emoji.fromFormatted("2️⃣")).queue();
                        message.addReaction(Emoji.fromFormatted("3️⃣")).queue();
                        message.addReaction(Emoji.fromFormatted("4️⃣")).queue();
                        message.addReaction(Emoji.fromFormatted("5️⃣")).queue();
                    });
                }
                } else {
                    e.reply("Du hast keine Berechtigung dafür!").setEphemeral(true).queue();
                }
            }
        }
    }