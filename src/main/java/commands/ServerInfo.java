package commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.util.Arrays;

public class ServerInfo extends Command {

    public ServerInfo(){
        this.name = "serverinfo";
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
        eb.setColor(Color.GREEN);
        eb.setAuthor(e.getGuild().getName());
        eb.setThumbnail("https://www.google.com/url?sa=i&url=https%3A%2F%2Fstore.hp.com%2Fus%2Fen%2Ftech-takes%2Fhow-to-overclock-pc-cpu&psig=AOvVaw0Qkqg6J0VKpMDjn9Y1F3gx&ust=1575094477328000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMDax6jijuYCFQAAAAAdAAAAABAE");
        eb.addField("Server Owner: " , e.getGuild().getOwner().getEffectiveName(), true);
        eb.addField("MemberCount: ", Integer.toString(e.getGuild().getMembers().size()), true);
        eb.setDescription("**Members: \n " + Arrays.toString(members) + "\n **Invite Link** \n" + "");

        //e.reply("This is a test");
        e.getChannel().sendMessage(eb.build()).queue();
    }

}
