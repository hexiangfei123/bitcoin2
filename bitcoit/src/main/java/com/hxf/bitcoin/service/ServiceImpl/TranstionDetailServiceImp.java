package com.hxf.bitcoin.service.ServiceImpl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hxf.bitcoin.client.BitcoinJsonRpc;
import com.hxf.bitcoin.dao.TransactionDetailMapper;
import com.hxf.bitcoin.dto.AddressDTO;
import com.hxf.bitcoin.enume.TxDetailType;
import com.hxf.bitcoin.po.Transaction;
import com.hxf.bitcoin.po.TransactionDetail;
import com.hxf.bitcoin.service.TransactionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TranstionDetailServiceImp implements TransactionDetailService {


    @Autowired
    private BitcoinJsonRpc bitcoinJsonRpc;
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

    @Override
    public void syncTXDetailVin(JSONObject vin, Integer transactionId) {
        TransactionDetail transactionDetail = new TransactionDetail();
        String txidVin = vin.getString("txid");
        Integer n = vin.getInteger("vout");
        transactionDetail.setType((byte)TxDetailType.Send.ordinal());
        transactionDetail.setTransactionId(transactionId);

        if(txidVin!=null && n!=null){
            try {
                JSONObject transactionJson = bitcoinJsonRpc.getRawTransaction(txidVin);

                JSONArray vouts = transactionJson.getJSONArray("vout");
                JSONObject vout = vouts.getJSONObject(n);
                Double amount = vout.getDouble("value");
                transactionDetail.setAmount(-amount);
                JSONObject scriptPubKey = vout.getJSONObject("scriptPubKey");
                JSONArray addresses = scriptPubKey.getJSONArray("addresses");
                if(addresses!=null){
                    String address = addresses.getString(0);
                    transactionDetail.setAddress(address);
                    transactionDetailMapper.insert(transactionDetail);

                }

            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }


        }





    }

    @Override
    public AddressDTO selectDetail(String address) {
       AddressDTO addressDTO= transactionDetailMapper.selectDetail(address);
        return addressDTO;
    }
}
