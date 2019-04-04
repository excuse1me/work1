package com.qianfeng.dao;



import com.qianfeng.entity.WxbGood;
import java.util.List;

/**
 * 商品管理
 */
public interface IGoodsDAO {

    List<WxbGood> queryGoodsByPage(Integer page) throws Exception;

    WxbGood queryGood(String goodId);

    void insertGood(WxbGood wxbGood);
}
