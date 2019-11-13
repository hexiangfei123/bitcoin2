package com.hxf.bitcoin.service;

import com.hxf.bitcoin.po.Block;

import java.util.List;

public interface BlockService {
    List<Block> getblocks();

    Block getByblockHash(String blockhash);

    void syncBlocks(String blockhash);
}
