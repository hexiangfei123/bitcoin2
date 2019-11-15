package com.hxf.bitcoin.controller;


import com.hxf.bitcoin.po.Transaction;
import com.hxf.bitcoin.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
@CrossOrigin
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/getTrans")
    public List<Transaction> getblocks(@RequestParam String blockId){
        List<Transaction> Transactions= transactionService.getTrans(blockId);
        return Transactions;
    }
    //交易详情
    @GetMapping("/getByTxhash")
    public Transaction getTransbyhash(@RequestParam String txhash){
        Transaction tran= transactionService.getTransbyhash(txhash);
        System.out.println("kkk");
        return tran;
    }
//    最近未确认的交易
    @GetMapping("/getRecentUnconfirmed")
    public List<Transaction> getRecentUnconfirmed(@RequestParam(required = false, defaultValue = "20") Integer size){
        List<Transaction> trans= transactionService.getRecentUnconfirmed();
        System.out.println("kkk");
        return trans;
    }



}
