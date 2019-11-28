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
            int rng = (int)(Math.random() * 10);


            if (event.getMember().getEffectiveName().equals("RKOdFromNoWhere")){

                if (rng == 0)
                    event.getChannel().sendMessage("Did you miss another AWP shot fuk boi? " + user).queue();
            }

            else if (event.getMember().getEffectiveName().equals("MrMustangRider")){

                if (rng == 0)
                    event.getChannel().sendMessage("Going to fail another calc 3 class pussy boi? " + user).queue();
            }

            else if (event.getMember().getEffectiveName().equals("austin B")){

                if (rng == 0)
                    event.getChannel().sendMessage("Go suck a mandingo! " + user).queue();
            }

            else if (event.getMember().getEffectiveName().equals("Ctrl")){

                if (rng == 0)
                    event.getChannel().sendMessage("STFU with your giraffe looking neck! " + user).queue();
            }

            else if (event.getMember().getEffectiveName().equals("ZacFromGeico")){

                if (rng == 0)
                    event.getChannel().sendMessage("Still playing only early access games dipshit? " + user).queue();
            }


        }
}
