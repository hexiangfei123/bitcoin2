package com.hxf.bitcoin.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BlockScheduler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private int count=0;


@Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Scheduled(fixedRate = 3000)
    public void syncBlockData(){
        count++;
        logger.info("sync block data"+count);
        Stu stu = new Stu();
        stu.setAge(11);
        stu.setName("张三");
        stu.setSex("男");






        simpMessagingTemplate.convertAndSend("/a/c", stu);



    }
}
