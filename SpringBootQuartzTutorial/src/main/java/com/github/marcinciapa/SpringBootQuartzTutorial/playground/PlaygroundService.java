package com.github.marcinciapa.SpringBootQuartzTutorial.playground;

import com.github.marcinciapa.SpringBootQuartzTutorial.info.TimerInfo;
import com.github.marcinciapa.SpringBootQuartzTutorial.jobs.HelloWorldJob;
import com.github.marcinciapa.SpringBootQuartzTutorial.timerservice.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaygroundService {
    private final SchedulerService scheduler;

    @Autowired
    public PlaygroundService(final SchedulerService scheduler) {
        this.scheduler = scheduler;
    }

    public void runHelloWorldJob() {
        final TimerInfo info = new TimerInfo();
        info.setTotalFireCount(5);
        info.setRepeatIntervalMs(2000);
        info.setInitialOffsetMs(1000);
        info.setCallbackData("My callback data");

        scheduler.schedule(HelloWorldJob.class, info);
    }

    public List<TimerInfo> getAllRunningTimers() {
        return scheduler.getAllRunningTimers();
    }

    public TimerInfo getRunningTimer(String timerId) {
        return scheduler.getRunningTimer(timerId);
    }
}
