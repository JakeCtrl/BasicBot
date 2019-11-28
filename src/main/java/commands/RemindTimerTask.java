package commands;

import java.util.TimerTask;

public class RemindTimerTask extends TimerTask {

    String text;

    @Override
    public void run(){

    }

    public void setText(String text){
        this.text = text;
    }

}
