package com.hxf.bitcoin.service;

import com.hxf.bitcoin.po.TransactionDetail;

import java.util.List;

public interface TransactionDetailService {
    List<TransactionDetail> getrecord(Integer transactionId);

    List<TransactionDetail> getaddress(String address);
}
