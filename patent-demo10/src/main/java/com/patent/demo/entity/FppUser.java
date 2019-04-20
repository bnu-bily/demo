package com.patent.demo.entity;

import java.util.Date;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author wwj
 * @since 2019-04-19
 */
public class FppUser extends Model<FppUser> {


    private static final long serialVersionUID = 1L;

    /**
     * hash(user_id)
     */
    @TableId
    private String uuid;
    @TableField
    private String userId;
    @TableField
    private String userPassword;
    /**
     * 注册请求人类型：1个人；2单位；3专利代理机构
     */
    @TableField
    private Integer registrationRequesterType;
    /**
     * 居民身份证号码
     */
    @TableField
    private String residentIdNumber;
    /**
     * 组织机构代码
     */
    @TableField
    private String organizationCode;
    /**
     * 营业执照号
     */
    @TableField
    private String businessLicenseNumber;
    /**
     * 专利代理机构
     */
    @TableField
    private String patentAgencyCode;
    /**
     * 其他证件名称
     */
    @TableField
    private String otherDocumentNameIdNumber;
    /**
     * 注册申请人姓名
     */
    @TableField
    private String rrName;
    /**
     * 国籍（地区）
     */
    @TableField
    private String rrRegion;
    /**
     * 地址
     */
    @TableField
    private String rrAddress;
    /**
     * 电话
     */
    @TableField
    private String rrTel;
    /**
     * 电子邮件
     */
    @TableField
    private String rrEmail;
    /**
     * 邮政编码
     */
    @TableField
    private String rrPostalCode;
    /**
     * 接收提示信息方式：1SMS;2email
     */
    @TableField
    private Integer rrReceiveInformation;
    /**
     * 数字证书形式：1USB-KEY；2网上申请下载
     */
    @TableField
    private Integer digitalCertificateForm;
    /**
     * 联系人姓名
     */
    @TableField
    private String contactName;
    /**
     * 联系人地址
     */
    @TableField
    private String contactAddress;
    /**
     * 联系人电话
     */
    @TableField
    private String contactTel;
    /**
     * 联系人电子邮箱
     */
    @TableField
    private String contactEmail;
    /**
     * 联系人身份证号码
     */
    @TableField
    private String contactIdNumber;
    /**
     * 经办人ID（审核者）
     */
    @TableField
    private String reviewId;
    /**
     * 经办人姓名（审核者）
     */
    @TableField
    private String reviewName;
    /**
     * 申请状态：1申请中；2通过；3拉黑
     */
    @TableField
    private Integer state;
    /**
     * 申请时间
     */
    @TableField
    private Date applicationTime;
    /**
     * 附件清单：依次为电子申请用户注册协议；身份证复印件;《组织机构代码证(副本)》复印件;《工商营业执照(副本)》复印;专利代理机构注册证复印件;经办人身份证复印件;代办注册委托书;其它文件。有填1无填0
     */
    @TableField
    private String listOfAccessories;
    /**
     * 信誉分，默认为10
     */
    @TableField
    private Integer reputation;
    /**
     * 附件（存储为地址）
     */
    @TableField
    private String annex;

    public  FppUser(){

    }


    public FppUser(String userId, String userPassword, String registrationRequesterName) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.rrName = registrationRequesterName;
    }

    public FppUser(String userId, String userPassword) {
        this.userId = userId;
        this.userPassword = userPassword;
    }

    public FppUser(String param) {
        this.userId="test1";
        this.userPassword="test1";
        this.registrationRequesterType=1;

        this.residentIdNumber="test1";
        this.patentAgencyCode="test1";
        this.rrName="test1";
        this.rrRegion="test1";

        this.rrAddress="test1";
        this.rrTel="test1";
        this.rrEmail="test1";
        this.rrPostalCode="test1";
        this.rrReceiveInformation=1;

        this.digitalCertificateForm=1;
        this.contactName="test1";
        this.contactAddress="test1";
        this.contactTel="test1";
        this.contactEmail="test1";

        this.contactIdNumber="test1";
        this.listOfAccessories="test1";
        this.reputation=10;
        this.annex = "test1";
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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Integer getRegistrationRequesterType() {
        return registrationRequesterType;
    }

    public void setRegistrationRequesterType(Integer registrationRequesterType) {
        this.registrationRequesterType = registrationRequesterType;
    }

    public String getResidentIdNumber() {
        return residentIdNumber;
    }

    public void setResidentIdNumber(String residentIdNumber) {
        this.residentIdNumber = residentIdNumber;
    }

    public String getOrganizationCode() {
        return organizationCode;
    }

    public void setOrganizationCode(String organizationCode) {
        this.organizationCode = organizationCode;
    }

    public String getBusinessLicenseNumber() {
        return businessLicenseNumber;
    }

    public void setBusinessLicenseNumber(String businessLicenseNumber) {
        this.businessLicenseNumber = businessLicenseNumber;
    }

    public String getPatentAgencyCode() {
        return patentAgencyCode;
    }

    public void setPatentAgencyCode(String patentAgencyCode) {
        this.patentAgencyCode = patentAgencyCode;
    }

    public String getOtherDocumentNameIdNumber() {
        return otherDocumentNameIdNumber;
    }

    public void setOtherDocumentNameIdNumber(String otherDocumentNameIdNumber) {
        this.otherDocumentNameIdNumber = otherDocumentNameIdNumber;
    }

    public String getRrName() {
        return rrName;
    }

    public void setRrName(String rrName) {
        this.rrName = rrName;
    }

    public String getRrRegion() {
        return rrRegion;
    }

    public void setRrRegion(String rrRegion) {
        this.rrRegion = rrRegion;
    }

    public String getRrAddress() {
        return rrAddress;
    }

    public void setRrAddress(String rrAddress) {
        this.rrAddress = rrAddress;
    }

    public String getRrTel() {
        return rrTel;
    }

    public void setRrTel(String rrTel) {
        this.rrTel = rrTel;
    }

    public String getRrEmail() {
        return rrEmail;
    }

    public void setRrEmail(String rrEmail) {
        this.rrEmail = rrEmail;
    }

    public String getRrPostalCode() {
        return rrPostalCode;
    }

    public void setRrPostalCode(String rrPostalCode) {
        this.rrPostalCode = rrPostalCode;
    }

    public Integer getRrReceiveInformation() {
        return rrReceiveInformation;
    }

    public void setRrReceiveInformation(Integer rrReceiveInformation) {
        this.rrReceiveInformation = rrReceiveInformation;
    }

    public Integer getDigitalCertificateForm() {
        return digitalCertificateForm;
    }

    public void setDigitalCertificateForm(Integer digitalCertificateForm) {
        this.digitalCertificateForm = digitalCertificateForm;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactIdNumber() {
        return contactIdNumber;
    }

    public void setContactIdNumber(String contactIdNumber) {
        this.contactIdNumber = contactIdNumber;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(Date applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getListOfAccessories() {
        return listOfAccessories;
    }

    public void setListOfAccessories(String listOfAccessories) {
        this.listOfAccessories = listOfAccessories;
    }

    public Integer getReputation() {
        return reputation;
    }

    public void setReputation(Integer reputation) {
        this.reputation = reputation;
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
        return "FppUser{" +
                "uuid=" + uuid +
                ", userId=" + userId +
                ", userPassword=" + userPassword +
                ", registrationRequesterType=" + registrationRequesterType +
                ", residentIdNumber=" + residentIdNumber +
                ", organizationCode=" + organizationCode +
                ", businessLicenseNumber=" + businessLicenseNumber +
                ", patentAgencyCode=" + patentAgencyCode +
                ", otherDocumentNameIdNumber=" + otherDocumentNameIdNumber +
                ", rrName=" + rrName +
                ", rrRegion=" + rrRegion +
                ", rrAddress=" + rrAddress +
                ", rrTel=" + rrTel +
                ", rrEmail=" + rrEmail +
                ", rrPostalCode=" + rrPostalCode +
                ", rrReceiveInformation=" + rrReceiveInformation +
                ", digitalCertificateForm=" + digitalCertificateForm +
                ", contactName=" + contactName +
                ", contactAddress=" + contactAddress +
                ", contactTel=" + contactTel +
                ", contactEmail=" + contactEmail +
                ", contactIdNumber=" + contactIdNumber +
                ", reviewId=" + reviewId +
                ", reviewName=" + reviewName +
                ", state=" + state +
                ", applicationTime=" + applicationTime +
                ", listOfAccessories=" + listOfAccessories +
                ", reputation=" + reputation +
                ", annex=" + annex +
                "}";
    }
}
