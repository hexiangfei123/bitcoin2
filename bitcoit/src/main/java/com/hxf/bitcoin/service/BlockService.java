package com.hxf.bitcoin.service;

import com.github.pagehelper.Page;
import com.hxf.bitcoin.dto.BlockListDTO;
import com.hxf.bitcoin.po.Block;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

public interface BlockService {
    List<Block> getblocks();

    BlockListDTO getByblockHash(String blockhash);
    String syncBlock(String blockhash);
    @Async
    void syncBlocks(String blockhash);

    Block getnewHash();

    Page<Block> getMoreblocks();

    BlockListDTO getInfoByHeight(Integer height);
}
