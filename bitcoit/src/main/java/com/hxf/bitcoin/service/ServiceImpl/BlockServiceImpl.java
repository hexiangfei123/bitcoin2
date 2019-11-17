package com.hxf.bitcoin.service.ServiceImpl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.hxf.bitcoin.client.BitcoinRest;
import com.hxf.bitcoin.dao.BlockMapper;
import com.hxf.bitcoin.dto.BlockDTO;
import com.hxf.bitcoin.po.Block;
import com.hxf.bitcoin.service.BlockService;

import com.hxf.bitcoin.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BlockServiceImpl implements BlockService {

    @Autowired
    private BlockMapper blockMapper;

  @Autowired
  private BitcoinRest bitcoinRest;
    @Autowired
    private TransactionService transactionService;


    public List<Block> getblocks(){
        List<Block> blocks= blockMapper.getblocks();
        return blocks;
    }

    @Override
    public BlockDTO getByblockHash(String blockhash) {
        return blockMapper.getByblockHash(blockhash);
    }


    public String syncBlock(String blockhash) {
        JSONObject blockJson = bitcoinRest.getBlockNoTxDetails(blockhash);
        Block block = new Block();
        block.setBlockhash(blockJson.getString("hash"));
        block.setConfirmations(blockJson.getInteger("confirmations"));
        block.setHeight(blockJson.getInteger("height"));
        block.setTime(blockJson.getLong("time"));
        block.setDifficulty(blockJson.getDouble("difficulty"));
        block.setSizeondisk(blockJson.getInteger("size"));
        block.setMerkleRoot(blockJson.getString("merkleroot"));
        block.setTxsize(blockJson.getInteger("nTx"));
        block.setVersion(blockJson.getString("versionHex"));
        block.setNonce(blockJson.getInteger("nonce"));
        block.setWeight(blockJson.getInteger("weight"));
        block.setBits(blockJson.getString("Bits"));


        blockMapper.insert(block);

        Integer blockId = block.getBlockId();
        Long time = block.getTime();



        //添加交易
        ArrayList<String> txids = (ArrayList<String>) blockJson.get("tx");
        for (String txid : txids) {
            transactionService.syncTransaction(txid, blockId, time);
        }






        String nextblockhash = blockJson.getString("nextblockhash");
        return nextblockhash;
    }

    @Override
    @Async
    public void syncBlocks(String fromBlockhash) {
        String tempBlockhash = fromBlockhash;
        while (tempBlockhash != null){
            tempBlockhash = syncBlock(tempBlockhash);
        }
    }

    @Override
    public Block getnewHash() {
        return blockMapper.getnewHash();
    }

    @Override
    public Page<Block> getMoreblocks() {
         Page<Block> blockPage=  blockMapper.getMoreblocks();
        return blockPage;
    }

    @Override
    public BlockDTO getInfoByHeight(Integer height) {

        return blockMapper.getInfoByHeight(height);
    }
}
