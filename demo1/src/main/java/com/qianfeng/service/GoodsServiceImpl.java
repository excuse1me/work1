package com.qianfeng.service;



import com.qianfeng.dao.IGoodsDAO;
import com.qianfeng.dao.impl.GoodsDAOImpl;
import com.qianfeng.entity.WxbGood;
import com.qianfeng.utils.SystemConstantsUtils;

import java.util.List;

public class GoodsServiceImpl implements IGoodsService {

    private IGoodsDAO goodsDAO = new GoodsDAOImpl();

    @Override
    public List<WxbGood> queryGoodsByPage(Integer page) throws Exception {
        if (page < 1) {
            throw new IndexOutOfBoundsException("页码不能小于1");
        }

        //计算起始下标
        int index = (page-1)* SystemConstantsUtils.Page.PAGE_SIZE;

        List<WxbGood> goods = goodsDAO.queryGoodsByPage(index);
        return goods;
    }

    @Override
    public WxbGood queryGood(String goodId) {
        return goodsDAO.queryGood(goodId);
    }

    @Override
    public void insertGood(WxbGood wxbGood) {
        goodsDAO.insertGood(wxbGood);
    }
}
