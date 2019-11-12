package com.study.timer;

import lombok.extern.log4j.Log4j2;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时器
 * @author lzr
 * @date 2019/5/14 0014 16:54
 */
@Log4j2
@Component
public class TestTimer {

    /**
     * 10秒运行一次
     */
    @Scheduled(cron = "*/10 * * * * *")
    public void removeSuspendedUser(){
        log.info("定时任务，10秒运行一次");
    }

}
