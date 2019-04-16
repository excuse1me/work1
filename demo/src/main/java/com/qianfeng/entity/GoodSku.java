package com.qianfeng.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
public class GoodSku implements Serializable {
    private String skuId;
    private String skuName;
    private String skuCost;
    private String skuPrice;
    private String skuPmoney;
    private String goodId;
    private Integer orderNo;
    private String serviceMoney;
    private Good good;
}
