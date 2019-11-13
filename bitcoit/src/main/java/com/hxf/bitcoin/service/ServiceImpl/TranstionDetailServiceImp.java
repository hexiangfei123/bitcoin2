package com.hxf.bitcoin.service.ServiceImpl;

import com.hxf.bitcoin.dao.TransactionDetailMapper;
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
}
