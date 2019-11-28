package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.time.OffsetDateTime;
import java.util.Timer;
import java.util.Date;
import java.util.TimerTask;

public class RemindMe extends ListenerAdapter {

    public void onGuildMessageReceived(GuildMessageReceivedEvent e) {

        int modifier = -1;
        String[] msg = e.getMessage().getContentRaw().split(" ");

        // Create OffsetDateTime obj from discord api
        OffsetDateTime sendTime = e.getMessage().getTimeCreated();

        // Create a date for execution
        Date date = new Date(sendTime.getDayOfYear(), sendTime.getDayOfMonth(), sendTime.getHour(), sendTime.getMinute(), sendTime.getSecond());

        // Create a Timer Obj
        Timer timer = new Timer();

        // TimerTask obj created
        RemindTimerTask task = new RemindTimerTask();


        if (msg[0].equalsIgnoreCase(";RemindMe")) {
            if (!e.getMember().getUser().isBot()) {

                if (msg[2].equalsIgnoreCase("Day")) {

                    modifier = 0;

                    // Get user number of days
                    Integer day = Integer.parseInt(msg[1]);

                    //e.getChannel().sendMessage("Yes" + e.getMessage().getTimeCreated()).queue();

                    // Add a amt of day'(s) to OffsetDateTime obj
                    sendTime = sendTime.plusDays(day);

                    // Change date obj to future time
                    date.setDate(day);

                    // Schedule a task
                    timer.schedule(task, date);

                    // setString in task

                    task.run();

                }
            }
        }
    }
}
