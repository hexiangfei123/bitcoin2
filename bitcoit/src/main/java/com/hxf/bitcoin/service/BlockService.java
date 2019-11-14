package com.hxf.bitcoin.service;

import com.hxf.bitcoin.po.Block;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface BlockService {
    List<Block> getblocks();

    Block getByblockHash(String blockhash);
    String syncBlock(String blockhash);
    @Async
    void syncBlocks(String blockhash);
}
