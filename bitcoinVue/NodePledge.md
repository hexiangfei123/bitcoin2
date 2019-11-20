##m.1 获取最新区块


- **获取最新区块**

```json
url:/Blocks/getblocks?page={page}&pageSize={pageSize}
method：GET
successResponse：
[
   { 
     "height":602845,
     "hash":"egtertrdgjdrktjerkterhjtojteyj",
     "Mined":"15232254",
     "Miner":"F2Pool",
     "Size":"1360526"
   },
     
    { 
     "height":602845,
     "hash":"egtertrdgjdrktjerkterhjtojteyj",
     "Mined":"15232254",
     "Miner":"F2Pool",
     "Size":"1360526"
   },

]
```

| RequestField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|   page          |  Integer  |     当前页  |
|   pageSize        |  Integer  |     当前页展示的条数  |

| ResponseField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|    hash|   String |  区块hash |
|    height|   Integer |  区块高度 |
|    Mined|   Date |  出块时间 |
|    Miner|   String |  旷工 |
|    Size|   Integer |  区块大小 |





## 2 根据区块hash获取区块详情

调用该API，可以根据当前用户状态设置操作后的状态

- **根据区块hash获取区块详情**

```json
url:/Blocks/getblocks?hash={hash}
method：GET
successResponse：
{
	"hash": "00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b",
    "Confirmations": 580643,
    "Timestamp": "00000000000000000005ac7036789bfec28d230dff491f3382f6daf6523f5c44",
    "Height": "00000000000000000024b3d4793dcbba032d3fc28a0d77a37d466b956fb68aa5",
    "Miner": "07ac3d1c827b5c3ef69a7341bbdb2bf72339139b5f9e7e782d1bc82265b17798",
    "txSiNumber of Transactionsze": 2702,
    "Difficulty": null,
    "Merkle root": 8766.38,
    "Version": 1560502355355,
    "Bits": 7409399249090.25,
    "Weight": 1322496,
    "Size": 8766.38,
    "Transaction Volume": 7409399249090.25,
    "Nonce": 1322496,
    "Block Reward": 8766.38,
    "Fee Reward": 1560502355355,
    "Transactions":[
        {
          "hash":"",
          "time":"1223",
          "TransactionDetails":[
              {
                 "address":"",
                 "amount":0.0125,
                 "type":0
              }          
          ]
        },
        {
          "hash":"",
          "time":"1223",
          "TransactionDetails":[
              {
                 "address":"",
                 "amount":0.0125,
                 "type":0
              }          
          ]
        }        
    ]
}


| ResponseField     |     Type |   Description   | 
|   hash            |  String  |     区块的hash  |
| :--------------: | :--------:| :------: |


| ResponseField              |     Type |   Description   | 
| :--------------:           |:--------:| :------: |
|   hash                     |  String  |     区块的hash  |
|   Confirmations            |  String  |     确认书  |
|   Timestamp                |  String  |     时间 |
|   Height                   |  String  |     高度  |
|   Miner                    |  String  |     旷工  |
|   txSiNumber of Transactionsze          |  String  |     交易数量  |
|   Difficulty               |  String  |     困难  |
|   Merkle root              |  String  |     默克尔根  |
|   Version                  |  String  |     版  |
|   Bits                     |  String  |     位  |
|   Weight                   |  String  |     重量  |
|   Size                     |  String  |     尺寸  |
|   Transaction Volume       |  String  |     随机数  |
|   Nonce                    |  String  |     交易量  |
|   Block Reward             |  String  |     封锁奖励  |
|   Fee Reward               |  String  |     费用缴奖励  |
|    Transactions            |   []    |  交易 |
| TransactionDetails         |   {}    |  交易记录 |
| address                    |   String    |  交易地址|
| type                       |   Integer    |  交易类型|
| amount                     |   Integer    |  金额|




## 3 交易详情
     
- **交易详情**



```json
url:/Blocks/Tx?hash={hash}
method：GET
successResponse：
{    
      "hash":"",
      "time":"1223",
      "TransactionDetails":[
              {
                 "address":"",
                 "amount":0.0125,
                 "type":0
              },
              {
                 "address":"",
                 "amount":0.0125,
                 "type":0
              },
              {
                 "address":"",
                 "amount":0.0125,
                 "type":0
              }   

       ]
}
```


| RequestField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|   hash          |  String  |     交易的hash  |
| ResponseField     |     Type |   Description   | 
| :--------------:  |:--------:| :------: |
|    hash           |   String |  交易的hash  |
| TransactionDetails   |   []     |  交易记录 |
| address            |   String    |  交易地址|
| type              |   Integer    |  交易类型|
| amount              |   Integer    |  金额|




##m.4 根据地址hash获取地址页面



- **根据地址hash获取地址页面**

```json
url:/Blocks/address?hash={hash}
method：GET
successResponse：
{
    "Address":"168mu3b86hBV7THnb26z5Czi4RZmhtRBHY",
    "Format":"BASE58 (P2PKH)",
    "Transactions":3,
    "Total Received":"2.06532322 BTC",
    "Total Sent":"2.06532322 BTC",
    "Final Balance":"0.00000000 BTC",


    "Transactions":[
        {
          "hash":"",
          "time":"1223",
          "TransactionDetails":[
              {
                 "address":"",
                 "amount":0.0125,
                 "type":0
              }          
          ]
        },
        {
          "hash":"",
          "time":"1223",
          "TransactionDetails":[
              {
                 "address":"",
                 "amount":0.0125,
                 "type":0
              }          
          ]
        }
    ] 
}
```
| RequestField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|   hash          |  String  |     地址的hash  |
| ResponseField     |     Type |   Description   | 
| :--------------:  |:--------:| :------: |
| address            |   String    |  地址|
| Format             |   String    |  格式|
| Transactions       |   Integer    |  交易次数|
| Total Receiv      |   Integer    |  收到的总数|
| Total Sent"       |   Integer    |  发送总数|
| Final Balance     |   Integer    |  最终余额|
|    Transactions   |   []     |  交易 |
| TransactionDetails|   {}     |  交易记录 |
| address            |   String    |  交易地址|
| type              |   Integer    |  交易类型|
| amount              |   Integer    |  金额|



##m.5 获取最近的交易



- **获取最近的交易**

```json
url:/Blocks/Transactions?page={page}&pageSize={pageSize}
method：GET
successResponse：
{
    "hash":"168mu3b86hBV7THnb26z5Czi4RZmhtRBHY",
    "Time":1251212332,
    "Amount(BTC)":3,
    "Amount(USD)":3,
    
}
```
| RequestField     |     Type |   Description   | 
| :--------------: | :--------:| :------: |
|   page          |  Integer |     当前页  |
|   pageSize         |  Integer |     当前页展示的条数  |
| ResponseField     |     Type |   Description   | 
| :--------------:  |:--------:| :------: |
| hash            |   String    |  交易哈希 |
| Time             |   String    |  时间  |
| Amount(BTC)    |   Integer    |  数量（BTC）|
| Amount(USD)    |   Integer    |  金额（美元）|



|    Transactions   |   []     |  交易 |
| TransactionDetails|   {}     |  交易记录 |
| address            |   String    |  交易地址|
| type              |   Integer    |  交易类型|
| amount              |   Integer    |  金额|





## 根据高度获取区块详情

调用该API，可以根据当前用户状态设置操作后的状态

- **根据高度获取区块详情**

```json
url:/Blocks/getblocks?Height={Height}
method：GET
successResponse：
{
	"hash": "00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b",
    "Confirmations": 580643,
    "Timestamp": "00000000000000000005ac7036789bfec28d230dff491f3382f6daf6523f5c44",
    "Height": "00000000000000000024b3d4793dcbba032d3fc28a0d77a37d466b956fb68aa5",
    "Miner": "07ac3d1c827b5c3ef69a7341bbdb2bf72339139b5f9e7e782d1bc82265b17798",
    "txSiNumber of Transactionsze": 2702,
    "Difficulty": null,
    "Merkle root": 8766.38,
    "Version": 1560502355355,
    "Bits": 7409399249090.25,
    "Weight": 1322496,
    "Size": 8766.38,
    "Transaction Volume": 7409399249090.25,
    "Nonce": 1322496,
    "Block Reward": 8766.38,
    "Fee Reward": 1560502355355,
    "Transactions":[
        {
          "hash":"",
          "time":"1223",
          "TransactionDetails":[
              {
                 "address":"",
                 "amount":0.0125,
                 "type":0
              }          
          ]
        },
        {
          "hash":"",
          "time":"1223",
          "TransactionDetails":[
              {
                 "address":"",
                 "amount":0.0125,
                 "type":0
              }          
          ]
        }        
    ]
}


| ResponseField     |     Type |   Description   | 
|   Height            |  String  |     区块的高度  |
| :--------------: | :--------:| :------: |


| ResponseField              |     Type |   Description   | 
| :--------------:           |:--------:| :------: |
|   hash                     |  String  |     区块的hash  |
|   Confirmations            |  String  |     确认书  |
|   Timestamp                |  String  |     时间 |
|   Height                   |  String  |     高度  |
|   Miner                    |  String  |     旷工  |
|   txSiNumber of Transactionsze          |  String  |     交易数量  |
|   Difficulty               |  String  |     困难  |
|   Merkle root              |  String  |     默克尔根  |
|   Version                  |  String  |     版  |
|   Bits                     |  String  |     位  |
|   Weight                   |  String  |     重量  |
|   Size                     |  String  |     尺寸  |
|   Transaction Volume       |  String  |     随机数  |
|   Nonce                    |  String  |     交易量  |
|   Block Reward             |  String  |     封锁奖励  |
|   Fee Reward               |  String  |     费用缴奖励  |
|    Transactions            |   []    |  交易 |
| TransactionDetails         |   {}    |  交易记录 |
| address                    |   String    |  交易地址|
| type                       |   Integer    |  交易类型|
| amount                     |   Integer    |  金额|