package com.hxf.bitcoin.controller;

import com.hxf.bitcoin.po.TransactionDetail;

import com.hxf.bitcoin.service.TransactionDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/record")
@CrossOrigin
public class TransactionDetailController {

    @Autowired
    private TransactionDetailService transactionDetailService;
    @GetMapping("/getrecord")
    public List<TransactionDetail> getblocks(@RequestParam Integer txid){
        List<TransactionDetail> records= transactionDetailService.getrecord(txid);
        return records;
    }
//根据地址查询交易记录金额

    @GetMapping("/address")
    public List<TransactionDetail> getaddress(@RequestParam String address){
        List<TransactionDetail> records= transactionDetailService.getaddress(address);
        return records;
    }




}
