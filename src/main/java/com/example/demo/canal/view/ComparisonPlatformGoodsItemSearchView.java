package com.example.demo.canal.view;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;
// import org.springframework.data.annotation.Id;
// import org.springframework.data.elasticsearch.annotations.Document;
// import org.springframework.data.elasticsearch.annotations.Field;
// import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

/**
 * @author neo 2021-01-21
 * 比价平台商品 搜索类
 */
@Data
@Accessors(chain = true)
// @Document(indexName = "comparison_platform_goods_item_index")
public class ComparisonPlatformGoodsItemSearchView implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Id
    private Long itemId;
    // @Field(type = FieldType.Keyword, index = false)
    private Long goodsId;
    // @Field(type = FieldType.Integer)
    private Integer userType;
    // @Field(type = FieldType.Keyword, index = false)
    private String merchantNick;
    // @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String title;
    // @Field(type = FieldType.Keyword, index = false)
    private String photoUrl;
    // @Field(type = FieldType.Keyword, index = false)
    private String link;
    // @Field(type = FieldType.Keyword, index = false)
    private String spuId;
    // @Field(type = FieldType.Keyword, index = false)
    private String skuId;
    /**
     * 优惠信息
     */
    // @Field(type = FieldType.Object, index = false)
    private DiscountInfo discountInfo;

    /**
     * 原价,页面价,划掉价
     */
    // @Field(type = FieldType.Keyword, index = false)
    private Double origPrice;
    /**
     * 现价,活动价
     */
    // @Field(type = FieldType.Keyword, index = false)
    private Double actPrice;
    /**
     * 到手价
     */
    // @Field(type = FieldType.Double)
    private Double finalDiscountPrice;

    /**
     * 到手价文本，防一手js精度问题和隐藏价格1??9
     */
    // @Field(type = FieldType.Keyword, index = false)
    private String finalDiscountPriceDisplay;
    // @Field(type = FieldType.Keyword, index = false)
    private String evaluationId;
    // 2020-12-09 新增
    // @Field(type = FieldType.Integer)
    private Long volumn;

    // @Field(type = FieldType.Keyword)
    private String brandId;
    // @Field(type = FieldType.Keyword)
    private Set<String> rankingCategoryId;
    // @Field(type = FieldType.Keyword)
    private Integer comparisonCategoryId;

    // 2021-03-04 新增【更新时间】,用于增量同步
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    // @Field(type = FieldType.Date)
    private Date priceUpdateTime;
    // 2021-03-15 新增【创建时间】,用于增量同步
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    // @Field(type = FieldType.Date)
    private Date createTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    // @Field(type = FieldType.Date)
    private Date updateTime;

    /**
     * 佣金比例
     */
    // @Field(type = FieldType.Double)
    private BigDecimal commissionRatio;

    /**
     * 优惠券抵扣比例=优惠券金额/商品原价
     */
    // @Field(type = FieldType.Double)
    private BigDecimal couponDeductionRatio;


    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)

    public static class DiscountInfo implements Serializable {
        // 1、优惠券类型（5种）
        // 1.1、普通优惠券
        private Boolean hasCoupon;
        private BigDecimal couponThreshold;
        private BigDecimal couponOff;
        private Date couponStartTime;
        private Date couponEndTime;
        private String couponUrl;
        // 1.2、可叠加优惠券
        private Boolean hasCouponOverlap;
        private BigDecimal couponOverlapThreshold;
        private BigDecimal couponOverlapOff;
        private Date couponOverlapStartTime;
        private Date couponOverlapEndTime;
        // 1.3、普通每满减优惠券
        private Boolean hasCouponPer;
        private BigDecimal couponPerThreshold;
        private BigDecimal couponPerEach; // 每满减金额
        private BigDecimal couponPerMax; // 每满减最大值
        private BigDecimal couponPerOff; // 最终可减金额
        private Date couponPerStartTime;
        private Date couponPerEndTime;
        // 1.4、可叠加每满减优惠券
        private Boolean hasCouponPerOverlap;
        private BigDecimal couponPerOverlapThreshold;
        private BigDecimal couponPerOverlapEach; // 每满减金额
        private BigDecimal couponPerOverlapMax; // 每满减最大值
        private BigDecimal couponPerOverlapOff; // 最终可减金额
        private Date couponPerOverlapStartTime;
        private Date couponPerOverlapEndTime;
        // 1.5、折扣优惠券
        private Boolean hasCouponDiscount;
        private BigDecimal couponDiscountThresholdNum;

        private BigDecimal couponDiscountThresholdPrice;
        private BigDecimal couponDiscountRate;
        private BigDecimal couponDiscountMax; // 折扣优惠最大值
        private BigDecimal couponDiscountOff; // 最终可减金额
        private Date couponDiscountStartTime;
        private Date couponDiscountEndTime;

        // 2、满减优惠（3种）
        // 2.1、普通满减
        private Boolean hasOverOff;
        private BigDecimal overOffThreshold;
        private BigDecimal overOffOff;
        private Date overOffStartTime;
        private Date overOffEndTime;
        // 2.2、普通每满减
        private Boolean hasOverOffPer;
        private BigDecimal overOffPerThreshold;
        private BigDecimal overOffPerEach;
        private BigDecimal overOffPerMax; // 每满减最大值
        private BigDecimal overOffPerOff; // 最终可减金额
        private Date overOffPerStartTime;
        private Date overOffPerEndTime;
        // 2.3、可叠加每满减
        private Boolean hasOverOffPerOverlap;
        private BigDecimal overOffPerOverlapThreshold;
        private BigDecimal overOffPerOverlapEach;
        private BigDecimal overOffPerOverlapMax; // 每满减最大值
        private BigDecimal overOffPerOverlapOff; // 最终可减金额
        private Date overOffPerOverlapStartTime;
        private Date overOffPerOverlapEndTime;


        // 3、折扣优惠
        private Boolean hasDiscount;
        private Boolean discountThresholdPrice;
        private Boolean discountThresholdNum;
        private BigDecimal discountRate; // 折扣比例，0-100
        private BigDecimal discountMax;
        private BigDecimal discountOff; // 最终可减金额
        private Date discountStartTime;
        private Date discountEndTime;

        // 4、预售优惠信息
        private Boolean hasPresale;
        private BigDecimal presaleOff;
        private Date presaleStartTime;
        private Date presaleEndTime;

        private static final long serialVersionUID = 1L;
    }

}