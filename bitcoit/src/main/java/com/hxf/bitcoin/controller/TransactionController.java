package com.hxf.bitcoin.controller;


import com.hxf.bitcoin.po.Transaction;
import com.hxf.bitcoin.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Trans")
@CrossOrigin
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("getTrans")
    public List<Transaction> getblocks(@RequestParam String blkId){
        List<Transaction> Transactions= transactionService.getTrans(blkId);
        return Transactions;
    }
    //交易详情
    @GetMapping("getTransbyhash")
    public Transaction getTransbyhash(@RequestParam String txhash){
        Transaction tran= transactionService.getTransbyhash(txhash);
        System.out.println("kkk");
        return tran;
    }
//    最近的交易
    @GetMapping("/Transactions")
    public List<Transaction> Transactions(){
        List<Transaction> trans= transactionService.Transactions();
        System.out.println("kkk");
        return trans;
    }



}
