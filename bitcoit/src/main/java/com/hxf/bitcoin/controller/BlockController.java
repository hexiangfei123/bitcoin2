package com.hxf.bitcoin.controller;


import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxf.bitcoin.dto.BlockListDTO;
import com.hxf.bitcoin.po.Block;
import com.hxf.bitcoin.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blocks")
@CrossOrigin
public class BlockController {
    @Autowired
    private BlockService blockService;
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
    public PageInfo<Block> getblocks(@RequestParam(required = false, defaultValue = "1") Integer page){
        PageHelper.startPage(page, 20);
        Page<Block> getblocks = blockService.getMoreblocks();
        PageInfo<Block> blockPageInfo = getblocks.toPageInfo();

        return blockPageInfo;
    }
    //区块详情
    @GetMapping("getByblockHash")
    public BlockListDTO getByblockHash(@RequestParam String blockhash){
        BlockListDTO block= blockService.getByblockHash(blockhash);
        return block;
    }

    @GetMapping("/getInfoByHeight")
    public BlockListDTO getInfoByHeight(@RequestParam Integer height){
        BlockListDTO block= blockService.getInfoByHeight(height);

        return block;
    }



}
