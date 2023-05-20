
//
// INFORMATION
//
// Dies hier ist ein noch nicht Veröffentliches "Game" also wir arbeiten dran.
//

package dev.dalol.Events;

import net.dv8tion.jda.api.entities.channel.Channel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RWGame extends ListenerAdapter {
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Channel channel = event.getGuild().getTextChannelById("1097932704609222676");

        if (event.getMessage().getChannel().equals(channel)) {
            if (event.getMessage().getContentStripped().equals("Pinguin")) {
                event.getChannel().sendMessage(event.getMember().getAsMention() + " hat das Wort erraten\n\nDas wort war: **Pinguin**").queue();
            }
        }
    }
}
