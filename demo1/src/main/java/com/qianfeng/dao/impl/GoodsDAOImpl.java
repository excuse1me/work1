package com.qianfeng.dao.impl;


import com.qianfeng.dao.IGoodsDAO;
import com.qianfeng.entity.WxbGood;
import com.qianfeng.mapper.GoodsMapper;
import com.qianfeng.utils.MyBatisSessionFactoryUtils;
import com.qianfeng.utils.SystemConstantsUtils;

import java.util.List;


public class GoodsDAOImpl implements IGoodsDAO {
    @Override
    public List<WxbGood> queryGoodsByPage(Integer page) throws Exception {
        GoodsMapper goodsMapper = MyBatisSessionFactoryUtils.getSession().getMapper(GoodsMapper.class);
        List<WxbGood> goods = goodsMapper.queryGoodsByPage(page, SystemConstantsUtils.Page.PAGE_SIZE);
        return goods;
    }

    @Override
    public WxbGood queryGood(String goodId) {
        GoodsMapper mapper = MyBatisSessionFactoryUtils.getSession().getMapper(GoodsMapper.class);
        WxbGood wxbGood = mapper.queryGood(goodId);
        return wxbGood;
    }

    @Override
    public void insertGood(WxbGood wxbGood) {
        GoodsMapper mapper = MyBatisSessionFactoryUtils.getSession().getMapper(GoodsMapper.class);
        mapper.insertGood(wxbGood);

    }
}
