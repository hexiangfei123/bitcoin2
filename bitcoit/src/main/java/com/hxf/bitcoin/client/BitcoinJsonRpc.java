package com.hxf.bitcoin.client;

import com.alibaba.fastjson.JSONObject;

public interface BitcoinJsonRpc {
    JSONObject getRawTransaction(String txid) throws Throwable;
}
