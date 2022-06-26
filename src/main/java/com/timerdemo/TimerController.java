package com.timerdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TimerController {

    @Autowired
    TimerService timerService;

    @GetMapping({"/", ""})
    public String getTimer(Model model){
        model.addAttribute("timer", timerService);
        return "index";
    }

    @GetMapping("/start")
    @ResponseBody
    public String startTimer(){
        timerService.setMinutesRemaining(5*60);
        timerService.start();
        return "Started Timer";
    }

    @GetMapping("/stop")
    @ResponseBody
    public String stopTimer(){
        timerService.minuteStoppedAt = timerService.getMinutes();
        timerService.cancel();
        System.out.println(timerService.minuteStoppedAt + "<------minutes stopped at");
        return "Stopped timer";
    }

    @GetMapping("/minutes")
    @ResponseBody
    public ResponseEntity<?> getMinutes(){
        System.out.println(timerService.getMinutes());
        return new ResponseEntity<>(timerService.getMinutes(), HttpStatus.OK);
    }
}
