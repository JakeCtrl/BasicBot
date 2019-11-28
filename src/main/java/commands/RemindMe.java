package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.OffsetDateTime;
import java.util.Date;

public class RemindMe extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent e){

        int modifier = -1;
        String[] msg = e.getMessage().getContentRaw().split(" ");
        OffsetDateTime sendTime = e.getMessage().getTimeCreated();
        String remindTime;

        if (msg[0].equalsIgnoreCase(";RemindMe")){
            if(!e.getMember().getUser().isBot()){
                //e.getChannel().sendMessage("Yes").queue();

                if(msg[1].equalsIgnoreCase("One") && msg[2].equalsIgnoreCase("Day")){
                    modifier = 0;
                    e.getChannel().sendMessage("Yes" + e.getMessage().getTimeCreated()).queue();

                    remindTime = setRemind(sendTime, modifier, "null");
                    remindTime = null;

                }
                else if(1 == 1){

                }
            }
        }

    }

    public String setRemind(OffsetDateTime t, int mod, String txt){

        if (mod == 0){
            t = t.plusDays(1);
            while (t != OffsetDateTime.now()) {

            }
            return "Blue Whale";
        }
        return "null";
    }




}
