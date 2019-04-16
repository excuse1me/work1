package com.qianfeng.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Good implements Serializable{
    private String goodId;
    private String goodName;
    private String customerId;
    private String goodPic;
    private String goodPic1;
    private String goodPic2;
    private String promoteDesc;
    private String skuTitle;
    private String skuCost;
    private String skuPrice;
    private String skuPmoney;
    private String copyIds;
    private String copyDesc;
    private String forwardLink;
    private Integer orderNo;
    private String typeId;
    private String tags;
    private Integer state;
    private Date createTime;
    private Integer toped;
    private Integer recomed;
    private Date topedTime;
    private Date recomedTime;
    private String spcId;
    private String zonId;
    private Integer sellNum;
    private String website;
    private Integer iswxpay;
    private Integer isfdfk;
    private Integer leixingId;
    private String kfqq;
    private List<GoodSku> goodSkuList;
}
