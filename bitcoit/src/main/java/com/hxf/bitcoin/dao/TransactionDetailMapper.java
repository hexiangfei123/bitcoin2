package com.hxf.bitcoin.dao;

import com.hxf.bitcoin.dto.AddressDTO;
import com.hxf.bitcoin.po.TransactionDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransactionDetailMapper {
    int deleteByPrimaryKey(Long txDetailId);

    int insert(TransactionDetail record);

    int insertSelective(TransactionDetail record);

    TransactionDetail selectByPrimaryKey(Long txDetailId);

    int updateByPrimaryKeySelective(TransactionDetail record);

    int updateByPrimaryKey(TransactionDetail record);
    List<TransactionDetail> getrecord(@Param("transactionId") Integer transactionId);

    List<TransactionDetail> getaddress(@Param("address")String address);

    AddressDTO selectDetail(@Param("address")String address);
}