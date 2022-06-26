package com.timerdemo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import java.util.Timer;
import java.util.TimerTask;

@Service
@Getter
@Setter
public class TimerService {
    public int minutesRemaining;
    public String minutes="00:00:00";
    public String minuteStoppedAt;

    Timer timer = new Timer();

    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            minutesRemaining--;
            minutes=getTimeString(minutesRemaining);
           }
    };

    public void  start(){
        timer.scheduleAtFixedRate(timerTask,1000,1000);
    }

    public void  cancel(){
        timer.cancel();
    }

   public String getTimeString(int s){

        int sec = s % 60;
        int min = (s / 60)%60;
        int hours = (s/60)/60;

        String strSec=(sec<10)?"0"+Integer.toString(sec):Integer.toString(sec);
        String strmin=(min<10)?"0"+Integer.toString(min):Integer.toString(min);
        String strHours=(hours<10)?"0"+Integer.toString(hours):Integer.toString(hours);

       System.out.println(strHours + ":" + strmin + ":" + strSec);

       return strHours + ":" + strmin + ":" + strSec;

    }
}
