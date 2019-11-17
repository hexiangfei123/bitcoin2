package com.hxf.bitcoin.dao;

import com.github.pagehelper.Page;
import com.hxf.bitcoin.dto.TransactionDTO;
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

    Page<TransactionDTO> getTrans(@Param("blockId") String blockId);

    Transaction getTransbyhash(@Param("txhash")String txhash);

    List<Transaction> Transactions();

    Page<TransactionDTO> getByBlockIdWithPage(Integer blockId);

    TransactionDTO getByTxid(@Param("txid")String txid);

    Page<TransactionDTO> getaddress(String address);
}