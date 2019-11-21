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

import java.util.*;
import java.util.stream.Collectors;

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
//    @Scheduled(fixedRate = 3000)
//    public void syncBlockData(){
//        count++;
//        logger.info("sync block data"+count);
//
//      Block b=  blockService.getnewHash();
//        String blockhash = b.getBlockhash();
//        JSONObject blockNoTxDetails = bitcoinRest.getBlockNoTxDetails(blockhash);
//        String nextblockhash = blockNoTxDetails.getString("nextblockhash");
//        if(nextblockhash!=null){
//            blockService.syncBlocks(nextblockhash);
//
//        }
//
//
//
//        simpMessagingTemplate.convertAndSend("/a/c",1);
//
//
//
//    }
    private JSONObject originMempoolTx = new JSONObject();

    private List<JSONObject> deltaTxes = new LinkedList<>();

    @Scheduled(cron = "${bitcoin.syncMempoolTx.interval}")
    public void syncMempoolTx(){
        logger.info("start");

        JSONObject mempoolContents = bitcoinRest.getMempoolContents();
        int memsize = mempoolContents.size();
        int origsize = originMempoolTx.size();
        if(memsize<=origsize){
             return ;
        }



        for (Map.Entry<String, Object> entry:mempoolContents.entrySet()) {
            String key = entry.getKey();
            if (!originMempoolTx.containsKey(key)){
                JSONObject addJson = mempoolContents.getJSONObject(key);
                addJson.put("txid", key);
                deltaTxes.add(addJson);
            }

        }

        logger.info("delta tx: "+deltaTxes);
        logger.info("or  size: "+originMempoolTx.size());
        logger.info("delta size: "+deltaTxes.size());
        List<JSONObject> detailTxjson = deltaTxes.stream().map(d -> {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("txid", d.getString("txid"));
            jsonObject.put("wtxid", d.getString("wtxid"));
            jsonObject.put("time", d.getLong("time"));
            return jsonObject;
        }).collect(Collectors.toList());

        List<JSONObject> detaSort = detailTxjson.stream().sorted(Comparator.comparingLong(t -> t.getLong("time"))).collect(Collectors.toList());
        System.out.println("//////");

        System.out.println(detaSort);
        System.out.println("//////");

        simpMessagingTemplate.convertAndSend("/bitcoin/deltaTx", detaSort);
        deltaTxes = new LinkedList<>();
        originMempoolTx = mempoolContents;

        logger.info("end");

    }
}
