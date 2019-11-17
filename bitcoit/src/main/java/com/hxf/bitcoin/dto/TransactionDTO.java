package com.hxf.bitcoin.dto;


import com.hxf.bitcoin.po.Transaction;
import com.hxf.bitcoin.po.TransactionDetail;


import java.util.Set;

public class TransactionDTO extends Transaction {
    private Set<TransactionDetail> TransactionDetails;

    public Set<TransactionDetail> getRecords() {
        return TransactionDetails;
    }

    public void setRecords(Set<TransactionDetail> TransactionDetails) {
        this.TransactionDetails = TransactionDetails;
    }
}
