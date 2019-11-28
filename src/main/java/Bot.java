
import commands.RemindMe;
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

        jda.addEventListener(new RkoEvent());
        jda.addEventListener(new RemindMe());

    }
}
