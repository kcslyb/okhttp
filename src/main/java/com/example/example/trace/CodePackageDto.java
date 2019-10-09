package com.example.example.trace;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.io.Serializable;
import java.util.Date;

/**
 * @author kcs
 * @date 2019-10-09 15:02
 **/
public class CodePackageDto implements Serializable {
    /**
     * 包装追溯码
     * <p>
     */
    private String id;

    /**
     * 追溯码
     * <p>
     */
    @Excel(name = "追溯码", width = 30)
    private String code;

    /**
     * 上级包装追溯码
     * <p>
     */
    private String parentId;

    /**
     * 状态 * 0=初始化;1=在库;2=已出库;3=已拆零;4=报废
     * <p>
     */
    private String status;

    /**
     * 批号Id
     * <p>
     */
    private String batchNumberId;

    /**
     * 货品Id
     * <p>
     */
    private String goodsId;

    /**
     * 货品编号(目前该参数只在两个方法中返回)
     * <p>
     */
    private String goodsCode;

    /**
     * 包装规则
     * <p>
     */
    @Excel(name = "包装规则", width = 30)
    private Integer packageScheme;

    /**
     * 批号
     * <p>
     */
    @Excel(name = "批号", width = 30)
    private String batchNumber;

    /**
     * 货品名称
     * <p>
     */
    @Excel(name = "货品名称", width = 50)
    private String goodsName;

    /**
     * 厂商Id
     * <p>
     */
    private String factoryId;

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

    /**
     * 质量标识
     * <p>
     */
    private Boolean qualifiedFlag;

    /**
     * 批签发号
     * <p>
     */
    private String batchReleaseNumber;

    /**
     * 批量/进口量
     * <p>
     */
    private Integer batchReleaseCount;

    /**
     * 批签发日期
     * <p>
     */
    private Date batchReleaseDate;

    /**
     * 口岸检验报告编号
     * <p>
     */
    private String receiptPortInspectionNumber;

    /**
     * 通关单号
     * <p>
     */
    private String receiptCustomsFormNumber;

    /**
     * 调整追溯码日志时使用
     * <p>
     */
    private String bizLogId;
    /**
     * 调整追溯码日志时使用
     * <p>
     */
    private String detailId;
    /**
     * 调整追溯码日志时使用
     * <p>
     */
    private String bizType;
    /**
     * 调整追溯码日志时使用
     * <p>
     */
    private Date logTime;

    private String orgId;

    private Integer subordinateCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBatchNumberId() {
        return batchNumberId;
    }

    public void setBatchNumberId(String batchNumberId) {
        this.batchNumberId = batchNumberId;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public Integer getPackageScheme() {
        return packageScheme;
    }

    public void setPackageScheme(Integer packageScheme) {
        this.packageScheme = packageScheme;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(String factoryId) {
        this.factoryId = factoryId;
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

    public Boolean getQualifiedFlag() {
        return qualifiedFlag;
    }

    public void setQualifiedFlag(Boolean qualifiedFlag) {
        this.qualifiedFlag = qualifiedFlag;
    }

    public String getBatchReleaseNumber() {
        return batchReleaseNumber;
    }

    public void setBatchReleaseNumber(String batchReleaseNumber) {
        this.batchReleaseNumber = batchReleaseNumber;
    }

    public Integer getBatchReleaseCount() {
        return batchReleaseCount;
    }

    public void setBatchReleaseCount(Integer batchReleaseCount) {
        this.batchReleaseCount = batchReleaseCount;
    }

    public Date getBatchReleaseDate() {
        return batchReleaseDate;
    }

    public void setBatchReleaseDate(Date batchReleaseDate) {
        this.batchReleaseDate = batchReleaseDate;
    }

    public String getReceiptPortInspectionNumber() {
        return receiptPortInspectionNumber;
    }

    public void setReceiptPortInspectionNumber(String receiptPortInspectionNumber) {
        this.receiptPortInspectionNumber = receiptPortInspectionNumber;
    }

    public String getReceiptCustomsFormNumber() {
        return receiptCustomsFormNumber;
    }

    public void setReceiptCustomsFormNumber(String receiptCustomsFormNumber) {
        this.receiptCustomsFormNumber = receiptCustomsFormNumber;
    }

    public String getBizLogId() {
        return bizLogId;
    }

    public void setBizLogId(String bizLogId) {
        this.bizLogId = bizLogId;
    }

    public String getDetailId() {
        return detailId;
    }

    public void setDetailId(String detailId) {
        this.detailId = detailId;
    }

    public String getBizType() {
        return bizType;
    }

    public void setBizType(String bizType) {
        this.bizType = bizType;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public Integer getSubordinateCount() {
        return subordinateCount;
    }

    public void setSubordinateCount(Integer subordinateCount) {
        this.subordinateCount = subordinateCount;
    }
}
