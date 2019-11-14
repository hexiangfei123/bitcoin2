package com.hxf.bitcoin.service.ServiceImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hxf.bitcoin.dao.TransactionDetailMapper;
import com.hxf.bitcoin.enume.TxDetailType;
import com.hxf.bitcoin.po.TransactionDetail;
import com.hxf.bitcoin.service.TransactionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TranstionDetailServiceImp implements TransactionDetailService {

    @Autowired
    private TransactionDetailMapper transactionDetailMapper;
    @Override
    public List<TransactionDetail> getrecord(Integer transactionId) {
        return transactionDetailMapper.getrecord(transactionId);
    }

    @Override
    public List<TransactionDetail> getaddress(String address) {
        return transactionDetailMapper.getaddress(address);
    }

    @Override
    public void syncTxDetailVout(JSONObject vout, Integer transactionId) {

        TransactionDetail transactionDetail = new TransactionDetail();
        JSONObject scriptPubKey = vout.getJSONObject("scriptPubKey");
        JSONArray addresses = scriptPubKey.getJSONArray("addresses");
        if (addresses != null){
            String address = (String) addresses.get(0);
            transactionDetail.setAddress(address);
            transactionDetail.setAmount(vout.getDouble("value"));
            transactionDetail.setType((byte) TxDetailType.Receive.ordinal());
            transactionDetail.setTransactionId(transactionId);

            transactionDetailMapper.insert(transactionDetail);
        }


    }
}
