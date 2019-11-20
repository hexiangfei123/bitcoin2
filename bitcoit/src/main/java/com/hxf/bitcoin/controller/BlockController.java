package com.hxf.bitcoin.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxf.bitcoin.dto.BlockDTO;
import com.hxf.bitcoin.dto.TransactionDTO;
import com.hxf.bitcoin.po.Block;
import com.hxf.bitcoin.service.BlockService;
import com.hxf.bitcoin.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blocks")
@CrossOrigin
public class BlockController {
    @Autowired
    private BlockService blockService;
    @Autowired
    private TransactionService transactionService;
    //最新区块列表
    @GetMapping("/getnewblocks")
  //  @SendTo("/a/c")
    public List<Block> getnewblocks(){
      List<Block> blocks= blockService.getblocks();
        return  blocks;
     // return blocks;
    }




    //更多区块列表
    @GetMapping("/getMoreblocks")
    public PageInfo<Block> getblocks(@RequestParam(required = false, defaultValue = "1") Integer page,Integer pagesize){
        PageHelper.startPage(page, 20);
        Page<Block> getblocks = blockService.getMoreblocks();
        PageInfo<Block> blockPageInfo = getblocks.toPageInfo();

        return blockPageInfo;
    }
    //区块详情
    @GetMapping("/getByblockHash")
    public BlockDTO getByblockHash(@RequestParam String blockhash,@RequestParam Integer page){
        BlockDTO block= blockService.getByblockHash(blockhash);
        Integer blockId = block.getBlockId();
        Page<TransactionDTO> trans = transactionService.getTrans(blockId.toString(), page);
        PageInfo<TransactionDTO> transactionDTOPageInfo = trans.toPageInfo();
        block.setTransactionDTOPageInfo(transactionDTOPageInfo);
        return block;
    }

    @GetMapping("/getInfoByHeight")
    public BlockDTO getInfoByHeight(@RequestParam Integer height){
        BlockDTO block= blockService.getInfoByHeight(height);

        return block;
    }



}
