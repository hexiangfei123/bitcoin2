package com.hxf.bitcoin.scheduler;

import com.alibaba.fastjson.JSONObject;
import com.hxf.bitcoin.client.BitcoinRest;
import com.hxf.bitcoin.po.Block;
import com.hxf.bitcoin.service.BlockService;
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
private BlockService blockService;
    @Autowired
    private BitcoinRest bitcoinRest;
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


      Block b=  blockService.getnewHash();
        String blockhash = b.getBlockhash();
        JSONObject blockNoTxDetails = bitcoinRest.getBlockNoTxDetails(blockhash);
        String nextblockhash = blockNoTxDetails.getString("nextblockhash");
        blockService.syncBlocks(nextblockhash);


        simpMessagingTemplate.convertAndSend("/a/c", stu);



    }
}
