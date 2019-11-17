package com.hxf.bitcoin.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.hxf.bitcoin.dto.AddressDTO;
import com.hxf.bitcoin.dto.TransactionDTO;
import com.hxf.bitcoin.po.TransactionDetail;

import com.hxf.bitcoin.service.TransactionDetailService;
import com.hxf.bitcoin.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactiondetail")
@CrossOrigin
public class TransactionDetailController {

    @Autowired
    private TransactionDetailService transactionDetailService;
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/gettransactiondetails")
    public List<TransactionDetail> getblocks(@RequestParam Integer transactionId){
        List<TransactionDetail> transactionDetails= transactionDetailService.getrecord(transactionId);
        return transactionDetails;
    }
//根据地址查询交易记录

    @GetMapping("/address")
    public AddressDTO getaddress(@RequestParam String address, @RequestParam(required = false,defaultValue = "1") Integer page){

        Page<TransactionDTO> transactionDTO=transactionService.getaddress(address,page);
        PageInfo<TransactionDTO> transactionDTOPageInfo = transactionDTO.toPageInfo();


       AddressDTO addressDTO= transactionDetailService.selectDetail(address);

        addressDTO.setTransactionDTO(transactionDTOPageInfo);



        return addressDTO;
    }




}
