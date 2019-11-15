package com.hxf.bitcoin.service.ServiceImpl;

import com.alibaba.fastjson.JSONObject;
import com.hxf.bitcoin.client.BitcoinRest;
import com.hxf.bitcoin.dao.TransactionMapper;
import com.hxf.bitcoin.po.Transaction;
import com.hxf.bitcoin.service.TransactionDetailService;
import com.hxf.bitcoin.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

@Service
public class TranstionServiceImp implements TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

    @Autowired
    private BitcoinRest bitcoinRest;

    @Autowired
    private TransactionDetailService transactionDetailService;

    @Override
    public List<Transaction> getTrans(String blkId) {
        return transactionMapper.getTrans(blkId);
    }

    @Override
    public Transaction getTransbyhash(String txhash) {
        return transactionMapper.getTransbyhash(txhash);
    }

    @Override
    public List<Transaction> Transactions() {
        return transactionMapper.Transactions();
    }

    public void syncTransaction(String txid, Integer blockId, Long time) {
      //  JSONObject transactionJson = bitcoinRest.getTransaction(txid);
        JSONObject transactionJson = bitcoinRest.getTransaction(txid);

        Transaction transaction = new Transaction();

        transaction.setBlockId(blockId);
        transaction.setSizeondisk(transactionJson.getInteger("size"));
        transaction.setStatus((byte)0);
        transaction.setTime(time);
        transaction.setTxhash(transactionJson.getString("hash"));
        transaction.setTxid(transactionJson.getString("txid"));
        transaction.setWeight(transactionJson.getInteger("weight"));

        transactionMapper.insert(transaction);

        Integer transactionId = transaction.getTransactionId();
       //添加vout
        List<JSONObject> vouts = transactionJson.getJSONArray("vout").toJavaList(JSONObject.class);
        for (JSONObject vout : vouts) {
            transactionDetailService.syncTxDetailVout(vout, transactionId);
        }

        //添加vin
        List<JSONObject> vins= transactionJson.getJSONArray("vin").toJavaList(JSONObject.class);
        for(JSONObject vin:vins){
            transactionDetailService.syncTXDetailVin(vin,transactionId);
        }


    }

    @Override
    public List<Transaction> getRecentUnconfirmed() {
        JSONObject mempoolContents = bitcoinRest.getMempoolContents();

        List<Transaction> list = new ArrayList<>();

        Set<String> strings = mempoolContents.keySet();
        for (String string : strings) {
            Transaction transaction = new Transaction();
            JSONObject o = mempoolContents.getJSONObject(string);
            transaction.setTxhash(string);
            transaction.setTime(o.getLong("time"));
            transaction.setFees(o.getDouble("fee"));
            list.add(transaction);
        }
        Collections.sort(list,Transaction::compareTo);

        return list;
    }
}
