package com.hxf.bitcoin.controller;

import com.hxf.bitcoin.po.TransactionDetail;

import com.hxf.bitcoin.service.TransactionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactiondetail")
@CrossOrigin
public class TransactionDetailController {

    @Autowired
    private TransactionDetailService transactionDetailService;
    @GetMapping("/gettransactiondetails")
    public List<TransactionDetail> getblocks(@RequestParam Integer transactionId){
        List<TransactionDetail> transactionDetails= transactionDetailService.getrecord(transactionId);
        return transactionDetails;
    }
//根据地址查询交易记录

    @GetMapping("/address")
    public List<TransactionDetail> getaddress(@RequestParam String address){
        List<TransactionDetail> transactionDetails=transactionDetailService.getaddress(address);
        return transactionDetails;
    }




}
