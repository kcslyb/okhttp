package com.example.example.trace;

import java.io.Serializable;
import java.util.Date;

/**
 * @author kcs
 * @date 2019-10-09 15:02
 **/
public class CodeStatisticsDto implements Serializable {
    private String goodsId;

    private String goodsName;

    private String batchNumber;

    /**
     * 厂商名称
     * <p>
     */
    private String factoryName;

    /**
     * 规格
     * <p>
     */
    private String specification;

    /**
     * 生产日期
     * <p>
     */
    private Date productionDate;

    /**
     * 有效期
     * <p>
     */
    private Date expirationDate;

    private String batchNumberId;

    private Integer count;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getBatchNumberId() {
        return batchNumberId;
    }

    public void setBatchNumberId(String batchNumberId) {
        this.batchNumberId = batchNumberId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
