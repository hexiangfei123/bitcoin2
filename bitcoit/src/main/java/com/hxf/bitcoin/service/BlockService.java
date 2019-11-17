package com.hxf.bitcoin.service;

import com.github.pagehelper.Page;
import com.hxf.bitcoin.dto.BlockDTO;
import com.hxf.bitcoin.po.Block;

import java.util.List;

public interface BlockService {
    List<Block> getblocks();

    BlockDTO getByblockHash(String blockhash);
    String syncBlock(String blockhash);

    void syncBlocks(String blockhash);

    Block getnewHash();

    Page<Block> getMoreblocks();

    BlockDTO getInfoByHeight(Integer height);

}
