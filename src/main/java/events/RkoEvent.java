package events;


import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import net.dv8tion.jda.api.events.user.UserTypingEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class RkoEvent extends ListenerAdapter {

        public void onGuildMessageReceived(GuildMessageReceivedEvent event){

            String messageSent = event.getMessage().getContentRaw();

            String name = event.getMember().getUser().getName();

            if (messageSent.equalsIgnoreCase("SuperTest")){
                if(!event.getMember().getUser().isBot()){
                        event.getChannel().sendMessage("Yo @" + name).queue();
                }
            }
        }

        public void onUserTyping(UserTypingEvent event){

            String user = event.getMember().getAsMention();
            int rng = (int)(Math.random() * 15);


            if (event.getMember().getEffectiveName().equals("RKOdFromNoWhere")){

                if (rng == 0)
                    event.getChannel().sendMessage("Hey" + user).queue();
            }

            else if (event.getMember().getEffectiveName().equals("MrMustangRider")){

                if (rng == 0)
                    event.getChannel().sendMessage("Hi? " + user).queue();
            }

            else if (event.getMember().getEffectiveName().equals("austin B")){

                if (rng == 0)
                    event.getChannel().sendMessage("How are you! " + user ).queue();
            }

            else if (event.getMember().getEffectiveName().equals("Ctrl")){

                if (rng == 0)
                    event.getChannel().sendMessage("^_^ " + user).queue();
            }

            else if (event.getMember().getEffectiveName().equals("ZacFromGeico")){

                if (rng == 0)
                    event.getChannel().sendMessage("How are you? " + user).queue();
            }


        }
}
