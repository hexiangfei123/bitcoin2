package com.hxf.bitcoin.dto;


import com.github.pagehelper.PageInfo;
import com.hxf.bitcoin.po.Block;

import com.hxf.bitcoin.po.TransactionDetail;

import java.util.Set;

public class BlockDTO extends Block {

    private PageInfo<TransactionDTO> transactionDTOPageInfo;

    public PageInfo<TransactionDTO> getTransactionDTOPageInfo() {
        return transactionDTOPageInfo;
    }

    public void setTransactionDTOPageInfo(PageInfo<TransactionDTO> transactionDTOPageInfo) {
        this.transactionDTOPageInfo = transactionDTOPageInfo;
    }


}
