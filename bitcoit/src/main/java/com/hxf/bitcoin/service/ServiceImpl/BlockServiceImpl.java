package com.hxf.bitcoin.service.ServiceImpl;

import com.hxf.bitcoin.dao.BlockMapper;
import com.hxf.bitcoin.po.Block;
import com.hxf.bitcoin.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BlockServiceImpl implements BlockService {

    @Autowired
    private BlockMapper blockMapper;


    public List<Block> getblocks(){
        List<Block> blocks= blockMapper.getblocks();
        return blocks;
    }

    @Override
    public Block getByblockHash(String blockhash) {
        return blockMapper.getByblockHash(blockhash);
    }
}