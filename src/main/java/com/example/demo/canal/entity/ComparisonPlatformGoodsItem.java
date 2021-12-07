package com.example.demo.canal.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 外部平台商品item
 */
@Data
public class ComparisonPlatformGoodsItem implements Serializable {

    private Long itemId;
    private Long goodsId;
    private Long specId;

    private Integer userType;

    private String merchantNick;

    private String title;

    private String photoUrl;

    private String link;

    private String spuId;

    private String skuId;

    /**
     * 优惠信息逻辑，待定，会考虑分离成多个字段
     */
    private DiscountInfo discountInfo;

    /**
     * 原价,页面价,划掉价
     */
    private BigDecimal origPrice;

    /**
     * 现价,活动价
     */
    private BigDecimal actPrice;

    /**
     * 到手价
     */
    private BigDecimal finalDiscountPrice;

    /**
     * 到手价文本，防一手js精度问题和隐藏价格1??9
     */
    private String finalDiscountPriceDisplay;

    private Boolean hasEvent;

    private String evaluationId;

    private String remark;

    private String evaluationTitle;

    private Long merchantId;
    private Boolean outdated;

    // 2020-12-09 新增
    private Long volumn;
    private BigDecimal commissionRatio;

    private static final long serialVersionUID = 1L;

    @Data
    public static class DiscountInfo implements Serializable {
        // 优惠券
        private Boolean hasCoupon;
        private BigDecimal couponThreshold;
        private BigDecimal couponOff;
        private Date couponStartTime;
        private Date couponEndTime;
        private String couponUrl;
        // 折扣优惠
        private Boolean hasDiscount;
        private BigDecimal discountRate; // 折扣比例，0-100
        private Date discountStartTime;
        private Date discountEndTime;
        // 预售优惠信息
        private Boolean hasPresale;
        private BigDecimal presaleOff;
        private Date presaleStartTime;
        private Date presaleEndTime;
        // 满减优惠
        private Boolean hasReduction;
        private BigDecimal reductionThreshold;
        private BigDecimal reductionOff;
        private Date reductionStartTime;
        private Date reductionEndTime;

        private static final long serialVersionUID = 1L;
    }
}