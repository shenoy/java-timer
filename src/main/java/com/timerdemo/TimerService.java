package com.timerdemo;
import org.springframework.stereotype.Service;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class TimerService {
    public int minutesRemaining = 60*1000;
    public int minuteStoppedAt = 0;
    Timer timer = new Timer();
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            minutesRemaining--;
            System.out.println(minutesRemaining + " minutes remaining");
        }
    };
    public void  start(){
        timer.scheduleAtFixedRate(timerTask,1000,1000);
    }
    public void  cancel(){
        timer.cancel();
    }
}
