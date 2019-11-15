package com.hxf.bitcoin.dao;

import com.github.pagehelper.Page;
import com.hxf.bitcoin.dto.BlockListDTO;
import com.hxf.bitcoin.po.Block;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlockMapper {
    int deleteByPrimaryKey(Integer blockId);

    int insert(Block record);

    int insertSelective(Block record);

    Block selectByPrimaryKey(Integer blockId);

    int updateByPrimaryKeySelective(Block record);

    int updateByPrimaryKey(Block record);

    List<Block> getblocks();
    BlockListDTO getByblockHash(@Param("blockhash") String blockhash);

    Block getnewHash();

    Page<Block> getMoreblocks();

    BlockListDTO getInfoByHeight(Integer height);
}