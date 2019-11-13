package com.hxf.bitcoin.service;

import com.hxf.bitcoin.po.Transaction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransactionService {
    List<Transaction> getTrans( String blkId);

    Transaction getTransbyhash(String txhash);

    List<Transaction> Transactions();
}
