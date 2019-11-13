package com.hxf.bitcoin.dto;

import com.hxf.bitcoin.po.Block;

import com.hxf.bitcoin.po.TransactionDetail;

import java.util.Set;

public class BlockListDTO extends Block {
    private Set<TransactionDetail> trans;

    public Set<TransactionDetail> getTrans() {
        return trans;
    }

    public void setTrans(Set<TransactionDetail> trans) {
        this.trans = trans;
    }

    public BlockListDTO(Set<TransactionDetail> trans) {
        this.trans = trans;
    }
    public BlockListDTO() {

    }
}
