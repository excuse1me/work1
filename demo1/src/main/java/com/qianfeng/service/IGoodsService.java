package com.qianfeng.service;



import com.qianfeng.entity.WxbGood;

import java.util.List;

public interface IGoodsService {

    List<WxbGood> queryGoodsByPage(Integer page) throws Exception;

    WxbGood queryGood(String goodId);

    void  insertGood(WxbGood wxbGood);
}
