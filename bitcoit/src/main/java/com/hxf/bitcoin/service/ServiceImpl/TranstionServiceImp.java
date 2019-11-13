package com.hxf.bitcoin.service.ServiceImpl;

import com.hxf.bitcoin.dao.TransactionMapper;
import com.hxf.bitcoin.po.Transaction;
import com.hxf.bitcoin.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TranstionServiceImp implements TransactionService {

    @Autowired
    private TransactionMapper transactionMapper;

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
}
