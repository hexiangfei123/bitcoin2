package com.hxf.bitcoin.dto;

import com.hxf.bitcoin.po.TransactionDetail;

import java.util.List;

public class TransactionDetailDTO {
    private String address;
    private String format;
    private String transactions;
   private String totalReceived;
   private String totalSent;
   private String finalBalance;

    private List<TransactionDetail> recordList;



}
