package com.hxf.bitcoin.controller;


import com.alibaba.fastjson.JSONObject;
import com.hxf.bitcoin.po.Block;
import com.hxf.bitcoin.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Blocks")
@CrossOrigin
public class BlockController {
    @Autowired
    private BlockService blockService;
    //最新区块列表
    @GetMapping("/getnewblocks")
    public List<Block> getnewblocks(){
      List<Block> blocks= blockService.getblocks();
      return blocks;
    }

//    //更多区块列表
//    @GetMapping("/getblocks")
//    public PageInfo<Block> getblocks(@RequestParam(required = false, defaultValue = "1") Integer page){
//        PageHelper.startPage(page, 2);
//        Page<Block> getblocks = blockMapper.getblocks();
//        PageInfo<Block> blockPageInfo = getblocks.toPageInfo();
//
//        return blockPageInfo;
//    }
//区块详情
    @GetMapping("getByblockHash")
    public Block getByblockHash(@RequestParam String blockhash){
        Block block= blockService.getByblockHash(blockhash);
        return block;
    }

    @GetMapping("/getInfoByHeight")
    public JSONObject getInfoByHeight(@RequestParam Integer height){
        return null;
    }


    @GetMapping("/getWithPage")
    public List<JSONObject> getWithPage(@RequestParam(required = false, defaultValue = "1") Integer page){
        return null;
    }
}
