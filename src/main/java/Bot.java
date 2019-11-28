
import commands.RemindMe;
import events.RkoEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Bot {
    public static void main(String[] argv) throws Exception {

        JDA jda = new JDABuilder("NTEyNDcyODM4NzQ2Mjc1ODcx.Xd2bLQ.twBWNT1UqEnie2WaT20fmgiI-QA").build();

        jda.addEventListener(new RkoEvent());
        jda.addEventListener(new RemindMe());

    }
}
