package com.hxf.bitcoin.service.ServiceImpl;

import com.hxf.bitcoin.dao.TransactionDetailMapper;
import com.hxf.bitcoin.po.TransactionDetail;
import com.hxf.bitcoin.service.TransactionDetailService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TranstionDetailServiceImp implements TransactionDetailService {

    @Autowired
    private TransactionDetailMapper transactionDetailMapper;
    @Override
    public List<TransactionDetail> getrecord(Integer txid) {
        return transactionDetailMapper.getrecord(txid);
    }

    @Override
    public List<TransactionDetail> getaddress(String address) {
        return transactionDetailMapper.getaddress(address);
    }
}
