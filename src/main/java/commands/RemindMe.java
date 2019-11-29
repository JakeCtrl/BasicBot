package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.time.OffsetDateTime;





public class RemindMe extends Command {


    public RemindMe(){
        super.name = "remindMe";
        super.help = "Set a reminder for the user";
        super.aliases  = new String[]{"remind"};
        super.cooldown = 10;

    }

    @Override
    protected void execute (CommandEvent event) {

        //Constants
        final int RATE = 1000;

        // Variables
        String[] reminder = event.getMessage().getContentRaw().split(" ");
        EmbedBuilder eb = new EmbedBuilder();

        OffsetDateTime timeCreated = event.getMessage().getTimeCreated();
        OffsetDateTime timeToDeliver = null;
        long secCreated = timeCreated.toEpochSecond();
        long secDeliver = 0;
        int delay = 0;

        // =========================================================================Setting up EmbedBuilder
        eb.setColor(Color.RED);
        eb.addField("**Reminder: **", event.getMessage().getContentRaw(), true);
        //==========================================================================

        if (reminder[1].equalsIgnoreCase("1") && reminder[2].equalsIgnoreCase("Sec") ){
            timeToDeliver = timeCreated.plusSeconds(Integer.parseInt(reminder[1]));
            secDeliver = timeToDeliver.toEpochSecond();
        }

        else if ((Integer.parseInt(reminder[1]) <= 60) && reminder[2].equalsIgnoreCase("Sec")){
            timeToDeliver = timeCreated.plusSeconds(Integer.parseInt(reminder[1]));
            secDeliver = timeToDeliver.toEpochSecond();
        }

        else if(reminder[1].equalsIgnoreCase("1") && reminder[2].equalsIgnoreCase("Min")){
            timeToDeliver = timeCreated.plusMinutes(1);
            secDeliver = timeToDeliver.toEpochSecond();
        }

        else if((Integer.parseInt(reminder[1]) >= 1) && reminder[2].equalsIgnoreCase("Mins")) {
            timeToDeliver = timeCreated.plusMinutes(Integer.parseInt(reminder[1]));
            secDeliver = timeToDeliver.toEpochSecond();
        }

        else if(reminder[1].equalsIgnoreCase("1") && reminder[2].equalsIgnoreCase("Day")){
            timeToDeliver = timeCreated.plusDays(1);
            secDeliver = timeToDeliver.toEpochSecond();
        }

        else if((Integer.parseInt(reminder[1]) >= 1) && reminder[2].equalsIgnoreCase("Days")) {
            timeToDeliver = timeCreated.plusDays(Integer.parseInt(reminder[1]));
            secDeliver = timeToDeliver.toEpochSecond();
        }

        else if(reminder[1].equalsIgnoreCase("1") && reminder[2].equalsIgnoreCase("Month")){
            timeToDeliver = timeCreated.plusMonths(1);
            secDeliver = timeToDeliver.toEpochSecond();
        }

        else if((Integer.parseInt(reminder[1]) >= 1) && reminder[2].equalsIgnoreCase("Months")) {
            timeToDeliver = timeCreated.plusDays(Integer.parseInt(reminder[1]));
            secDeliver = timeToDeliver.toEpochSecond();
        }

        else {
            timeToDeliver = timeCreated;
            secDeliver = secCreated;
        }








        try{
            if (!(timeToDeliver == timeCreated)){
                Thread.sleep((secDeliver - secCreated)* RATE);
                event.getChannel().sendMessage(eb.build()).queue();
            }
            else{
                event.reply(event.getMember().getAsMention() +" Invalid Input");
            }

        }catch (Exception e){

        }

    }
}
