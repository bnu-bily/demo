package com.patent.demo.entity;

import java.util.Date;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;

/**
 * <p>
 * <p>
 * </p>
 *
 * @author wwj
 * @since 2019-04-19
 */
public class FppOperation extends Model<FppOperation> {


    private static final long serialVersionUID = 1L;

    /**
     * hashStr(userId + userName + currentTime)
     */
    @TableId
    private String uuid;
    /**
     * 用户id
     */
    @TableField
    private String userId;
    /**
     * 用户姓名
     */
    @TableField
    private String userName;
    /**
     * 专利类型：1发明专利；2实用新型专利；3外观设计专利
     */
    @TableField
    private Integer patentType;
    /**
     * 目标专利
     */
    @TableField
    private String patentId;
    /**
     * 专利名称
     */
    @TableField
    private String patentName;
    /**
     * 操作：1申请用户；2拉黑用户（撤销拉黑）；3初次审查专利；4补正专利；5实质审查专利；6撤销专利；7恢复专利；8续费专利；10转让专利；
     */
    @TableField
    private Integer operationType;
    /**
     * 转让的目标用户ID
     */
    @TableField
    private String transferUserId;
    /**
     * 转让的目标用户名称
     */
    @TableField
    private String transferUserName;
    /**
     * 操作时间
     */
    @TableField
    private Date operationTime;
    /**
     * 缴费金额（RMB）
     */
    @TableField
    private String payment;
    /**
     * 缴费时间
     */
    @TableField
    private Date paymentTime;
    /**
     * 审核人id
     */
    @TableField
    private String reviewId;
    /**
     * 审核人姓名
     */
    @TableField
    private String reviewName;
    /**
     * 审核时间
     */
    @TableField
    private Date reviewTime;
    /**
     * 是否通过：1是；0否
     */
    @TableField
    private Integer isAgree;
    /**
     * 附件提交时间
     */
    @TableField
    private Date annexSubmitTime;
    /**
     * 附件（存储为地址）
     */
    @TableField
    private String annex;

    public FppOperation() {
    }

    public FppOperation(String userId, String userName, int patentType, String patentId, String patentName) {
        this.userId = userId;
        this.userName = userName;
        this.patentType = patentType;
        this.patentId = patentId;
        this.patentName = patentName;
    }

    public FppOperation(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPatentType() {
        return patentType;
    }

    public void setPatentType(Integer patentType) {
        this.patentType = patentType;
    }

    public String getPatentId() {
        return patentId;
    }

    public void setPatentId(String patentId) {
        this.patentId = patentId;
    }

    public String getPatentName() {
        return patentName;
    }

    public void setPatentName(String patentName) {
        this.patentName = patentName;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public String getTransferUserId() {
        return transferUserId;
    }

    public void setTransferUserId(String transferUserId) {
        this.transferUserId = transferUserId;
    }

    public String getTransferUserName() {
        return transferUserName;
    }

    public void setTransferUserName(String transferUserName) {
        this.transferUserName = transferUserName;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewName() {
        return reviewName;
    }

    public void setReviewName(String reviewName) {
        this.reviewName = reviewName;
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    public Integer getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(Integer isAgree) {
        this.isAgree = isAgree;
    }

    public Date getAnnexSubmitTime() {
        return annexSubmitTime;
    }

    public void setAnnexSubmitTime(Date annexSubmitTime) {
        this.annexSubmitTime = annexSubmitTime;
    }

    public String getAnnex() {
        return annex;
    }

    public void setAnnex(String annex) {
        this.annex = annex;
    }

    @Override
    protected Serializable pkVal() {
        return this.uuid;
    }

    @Override
    public String toString() {
        return "FppOperation{" +
                "uuid=" + uuid +
                ", userId=" + userId +
                ", userName=" + userName +
                ", patentType=" + patentType +
                ", patentId=" + patentId +
                ", patentName=" + patentName +
                ", operationType=" + operationType +
                ", transferUserId=" + transferUserId +
                ", transferUserName=" + transferUserName +
                ", operationTime=" + operationTime +
                ", payment=" + payment +
                ", paymentTime=" + paymentTime +
                ", reviewId=" + reviewId +
                ", reviewName=" + reviewName +
                ", reviewTime=" + reviewTime +
                ", isAgree=" + isAgree +
                ", annexSubmitTime=" + annexSubmitTime +
                ", annex=" + annex +
                "}";
    }
}
