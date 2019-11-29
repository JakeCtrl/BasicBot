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
        eb.setThumbnail("http://img3.wikia.nocookie.net/__cb20121223024203/callofduty/images/f/f1/Zombie_Rank_8_Icon_BOII.png");
        eb.addField("Server Owner: " , e.getGuild().getOwner().getEffectiveName(), true);
        //eb.addField("MemberCount: ", Integer.toString(e.getGuild().getMembers().size()), true);
        eb.setDescription("**Invite Link** \n" + "");

        //e.reply("This is a test");
        e.getChannel().sendMessage(eb.build()).queue();
    }

}
