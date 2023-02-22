package com.yezhiyuan.imports;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PushNoticeTask {


    public PushNoticeTask(){
        System.out.println("PushNoticeTask  初始化");
    }




    /**
     * 版本发布,每 5分钟扫描一次
     */
    @Async
    @Scheduled(cron = "0 0/5 * * * ?")
    public void releaseVersion() {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>开始执行扫描上线定时任务>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>上线定时任务执行结束>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

    }

}
