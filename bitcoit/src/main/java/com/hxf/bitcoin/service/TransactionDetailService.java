package com.hxf.bitcoin.service;

import com.alibaba.fastjson.JSONObject;
import com.hxf.bitcoin.po.TransactionDetail;

import java.util.List;

public interface TransactionDetailService {
    List<TransactionDetail> getrecord(Integer transactionId);

    List<TransactionDetail> getaddress(String address);

    void syncTxDetailVout(JSONObject vout, Integer transactionId);
}
