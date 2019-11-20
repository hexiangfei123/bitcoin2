package com.hxf.bitcoin.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.hxf.bitcoin.dto.TransactionDTO;
import com.hxf.bitcoin.po.Block;
import com.hxf.bitcoin.po.Transaction;
import com.hxf.bitcoin.service.BlockService;
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

    @Autowired
    private BlockService blockService;

    @GetMapping("/getTrans")
    public  PageInfo<TransactionDTO>  getblocks(@RequestParam String blockId,@RequestParam(required = false, defaultValue = "1") Integer size){

        Page<TransactionDTO> Transactions= transactionService.getTrans(blockId,size);
        PageInfo<TransactionDTO> transactionDTOPageInfo = Transactions.toPageInfo();
        return transactionDTOPageInfo;
    }
    //交易详情
    @GetMapping("/getByTxid")
    public TransactionDTO getByTxid(@RequestParam String txhash){
        TransactionDTO tran= transactionService.getByTxid(txhash);
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

   //区块交易
    @GetMapping("/getByBlockhashWithPage")
    public PageInfo<TransactionDTO> getByBlockhashWithPage(@RequestParam String blockhash,
                                                 @RequestParam(required = false, defaultValue = "1") Integer page){


        Block block = blockService.getByblockHash(blockhash);
        Integer blockId = block.getBlockId();
        Page<TransactionDTO> pageTx =  transactionService.getByBlockIdWithPage(blockId, page);
        PageInfo<TransactionDTO> transactionDTOPageInfo = pageTx.toPageInfo();



        return transactionDTOPageInfo;
    }



}
