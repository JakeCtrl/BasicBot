package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.util.Arrays;

public class ServerInfo extends Command {

    public ServerInfo(){
        this.name = "ServerInfo";
        this.aliases = new String[]{"server"};
        this.help = "Gives information about the server.";

    }

    @Override
    protected void execute(CommandEvent e){

        String[] members = new String[e.getGuild().getMembers().size()];
        for (int i = 0; i < e.getGuild().getMembers().size(); i++){
            members[i] = e.getGuild().getMembers().get(i).getEffectiveName();
        }

        EmbedBuilder eb = new EmbedBuilder();
        eb.setColor(Color.RED);
        eb.setAuthor(e.getGuild().getName());
        eb.setThumbnail(  e.getGuild().getIconUrl());
        eb.addField("Server Owner: " , e.getGuild().getOwner().getEffectiveName(), true);
        //eb.addField("MemberCount: ", Integer.toString(e.getGuild().getMembers().size()), true);
        eb.setDescription("**Invite Link** \n" + " PLACEHOLDER ");

        //e.reply("This is a test");

        // Build the EmbedBuilder plus send the message
        e.getChannel().sendMessage(eb.build()).queue();
    }

}
