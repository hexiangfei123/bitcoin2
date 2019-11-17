package com.hxf.bitcoin.service;

import com.github.pagehelper.Page;
import com.hxf.bitcoin.dto.TransactionDTO;
import com.hxf.bitcoin.po.Transaction;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransactionService {
    Page<TransactionDTO> getTrans( String blkId,Integer size);

    Transaction getTransbyhash(String txhash);

    List<Transaction> Transactions();
    void syncTransaction(String txid, Integer blockId, Long time);

    List<Transaction> getRecentUnconfirmed();

    Page<TransactionDTO> getByBlockIdWithPage(Integer blockId, Integer page);

    TransactionDTO getByTxid(String txid);

    Page<TransactionDTO> getaddress(@Param("address") String address, Integer page);
}
