package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.time.OffsetDateTime;
import java.util.Arrays;


public class Countdown extends Command {


    public Countdown(){
        super.name = "Countdown";
        super.help = "Create a count for the user ";
        super.aliases  = new String[]{"Count"};
        super.cooldown = 10;

    }

    @Override
    protected void execute (CommandEvent event) {



        }
    }
