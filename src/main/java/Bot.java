
import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import commands.RemindMe;
import commands.ServerInfo;
import events.RkoEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import java.util.Scanner;
import java.io.File;

import javax.security.auth.login.LoginException;

public class Bot {
    public static void main(String[] argv) throws Exception {

        File file = new File("C:\\Users\\Ctrl\\IdeaProjects\\BasicBot\\src\\main\\java\\token.txt");
        Scanner input = new Scanner(file);
        String token = input.nextLine();


        JDA jda = new JDABuilder(token).build();

        EventWaiter waiter = new EventWaiter();
        //jda.addEventListener(new RkoEvent());
        //jda.addEventListener(new RemindMe());

        CommandClientBuilder builder = new CommandClientBuilder();

        // Sets the Client ID to the CommandClientBuilder obj
        builder.setOwnerId("512472838746275871");

        // Sets the prefix for the bot to *
        builder.setPrefix("*");

        // Sets help word to PlsHelp
        builder.setHelpWord("PlsHelp");

        // Adds a new command to the builder
        // ==============================================================================Commands
        builder.addCommand(new ServerInfo());

        builder.addCommand(new RemindMe());

        // Creates new client obj by using the .build method on the CommandClientBuilder
        CommandClient client = builder.build();

        jda.addEventListener(client);
    }
}
