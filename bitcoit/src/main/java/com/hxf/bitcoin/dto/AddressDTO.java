package com.hxf.bitcoin.dto;

import com.github.pagehelper.PageInfo;
import com.hxf.bitcoin.po.TransactionDetail;

import java.util.List;

public class AddressDTO {
    private String address;
    private String  format;
    private int txSize;
    private double totalReceived;

   private double  totalSent;
   private  double balance;

    private PageInfo<TransactionDTO>  TransactionDTO;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getTxSize() {
        return txSize;
    }

    public void setTxSize(int txSize) {
        this.txSize = txSize;
    }

    public double getTotalReceived() {
        return totalReceived;
    }

    public void setTotalReceived(double totalReceived) {
        this.totalReceived = totalReceived;
    }

    public double getTotalSent() {
        return totalSent;
    }

    public void setTotalSent(double totalSent) {
        this.totalSent = totalSent;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public PageInfo<com.hxf.bitcoin.dto.TransactionDTO> getTransactionDTO() {
        return TransactionDTO;
    }

    public void setTransactionDTO(PageInfo<com.hxf.bitcoin.dto.TransactionDTO> transactionDTO) {
        TransactionDTO = transactionDTO;
    }

    public AddressDTO(String address, String format, int txSize, double totalReceived, double totalSent, double balance, PageInfo<com.hxf.bitcoin.dto.TransactionDTO> transactionDTO) {
        this.address = address;
        this.format = format;
        this.txSize = txSize;
        this.totalReceived = totalReceived;
        this.totalSent = totalSent;
        this.balance = balance;
        TransactionDTO = transactionDTO;
    }

    public AddressDTO() {

    }
}
