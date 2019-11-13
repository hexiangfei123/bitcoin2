package com.hxf.bitcoin.dao;

import com.hxf.bitcoin.po.Transaction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransactionMapper {
    int deleteByPrimaryKey(Integer transactionId);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(Integer transactionId);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);

    List<Transaction> getTrans(@Param("blockId") String blkId);

    Transaction getTransbyhash(@Param("txhash")String txhash);

    List<Transaction> Transactions();
}