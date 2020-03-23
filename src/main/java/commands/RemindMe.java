package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.time.OffsetDateTime;
import java.util.Arrays;


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
        String[] userReminder = Arrays.copyOfRange(reminder, 3, reminder.length);
        EmbedBuilder eb = new EmbedBuilder();


        OffsetDateTime timeCreated = event.getMessage().getTimeCreated();
        OffsetDateTime timeToDeliver = null;
        long secCreated = timeCreated.toEpochSecond();
        long secDeliver = 0;
        int delay = 0;

        // =========================================================================Setting up EmbedBuilder
        eb.setColor(Color.RED);
        eb.addField("**Reminder: **", convertArrayToStringUsingStreamAPI(userReminder) , true);
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

        else if(reminder[1].equalsIgnoreCase("1") && reminder[2].equalsIgnoreCase("Hour")){
            timeToDeliver = timeCreated.plusHours(1);
            secDeliver = timeToDeliver.toEpochSecond();
        }

        else if((Integer.parseInt(reminder[1]) >= 1) && reminder[2].equalsIgnoreCase("Hours")) {
            timeToDeliver = timeCreated.plusHours(Integer.parseInt(reminder[1]));
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

        else if(reminder[1].equalsIgnoreCase("1") && reminder[2].equalsIgnoreCase("Week")){
            timeToDeliver = timeCreated.plusWeeks(1);
            secDeliver = timeToDeliver.toEpochSecond();
        }

        else if((Integer.parseInt(reminder[1]) >= 1) && reminder[2].equalsIgnoreCase("Weeks")) {
            timeToDeliver = timeCreated.plusWeeks(Integer.parseInt(reminder[1]));
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

        else if(reminder[1].equalsIgnoreCase("1") && reminder[2].equalsIgnoreCase("Year")){
            timeToDeliver = timeCreated.plusMonths(1);
            secDeliver = timeToDeliver.toEpochSecond();
        }

        else if((Integer.parseInt(reminder[1]) >= 1) && reminder[2].equalsIgnoreCase("Years")) {
            timeToDeliver = timeCreated.plusDays(Integer.parseInt(reminder[1]));
            secDeliver = timeToDeliver.toEpochSecond();
        }

        // ===============================================================================Other Args



        else {
            timeToDeliver = timeCreated;
            secDeliver = secCreated;
        }

        try{
            if (!(timeToDeliver == timeCreated)){
                Thread.sleep((secDeliver - secCreated)* RATE);
                event.reply(event.getMember().getAsMention());
                event.getChannel().sendMessage(eb.build()).queue();
            }
            else{
                event.reply(event.getMember().getAsMention() +" Invalid Input");
            }

        }catch (Exception e){

        }
    }

    public static String convertArrayToStringUsingStreamAPI(String[] strArray) {
        String joinedString = String.join(" ", strArray);
        return joinedString;
    }
}
