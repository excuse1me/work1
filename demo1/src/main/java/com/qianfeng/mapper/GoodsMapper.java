package com.qianfeng.mapper;


import com.qianfeng.entity.WxbGood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    List<WxbGood> queryGoodsByPage(@Param("index") Integer index, @Param("size") Integer size);

    WxbGood queryGood(@Param("goodId") String goodId);

    void insertGood(WxbGood wxbGood);
}
