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
public class FppAdmin extends Model<FppAdmin> {


    private static final long serialVersionUID = 1L;

    /**
     * hash(adminId + adminName）
     */
    @TableId
    private String uuid;
    /**
     * 管理员账号
     */
    @TableField
    private String adminId;
    /**
     * 管理员类型:1.用户管理员；2专利管理员
     */
    @TableField
    private Integer adminType;
    /**
     * 管理员密码
     */
    @TableField
    private String adminPassword;
    /**
     * 注册码
     */
    @TableField
    private String registrationCode;
    /**
     * 注册时间
     */
    @TableField
    private Date registrationTime;
    /**
     * 管理员姓名
     */
    @TableField
    private String adminName;
    /**
     * 地区
     */
    @TableField
    private String adminRegion;
    /**
     * 管理员身份证号码
     */
    @TableField
    private String adminIdNumber;
    /**
     * 地址
     */
    @TableField
    private String adminAddress;
    /**
     * 电话
     */
    @TableField
    private String adminTel;
    /**
     * 电子邮箱
     */
    @TableField
    private String adminEmail;
    /**
     * 邮政编码
     */
    @TableField
    private String adminPostalCode;
    /**
     * 管理员状态：1有效；2失效
     */
    @TableField
    private Integer state;

    public FppAdmin() {
    }

    public FppAdmin(String adminId, String adminName, String adminPassword) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }

    public FppAdmin(String adminId, String adminPassword) {
        this.adminId = adminId;
        this.adminPassword = adminPassword;
    }

    public FppAdmin(String param){
        this.adminId = "test1";
        this.adminName = "test1";
        this.adminPassword = "test1";
        this.registrationCode = "test1";
        this.registrationTime = new Date();
        this.adminRegion = "test1";
        this.adminIdNumber  = "test1";
        this.adminAddress = "test1";
        this.adminTel = "test1";
        this.adminEmail = "test1";
        adminPostalCode = "test1";
        this.state = 1;
    }
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public Integer getAdminType() {
        return adminType;
    }

    public void setAdminType(Integer adminType) {
        this.adminType = adminType;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getRegistrationCode() {
        return registrationCode;
    }

    public void setRegistrationCode(String registrationCode) {
        this.registrationCode = registrationCode;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminRegion() {
        return adminRegion;
    }

    public void setAdminRegion(String adminRegion) {
        this.adminRegion = adminRegion;
    }

    public String getAdminIdNumber() {
        return adminIdNumber;
    }

    public void setAdminIdNumber(String adminIdNumber) {
        this.adminIdNumber = adminIdNumber;
    }

    public String getAdminAddress() {
        return adminAddress;
    }

    public void setAdminAddress(String adminAddress) {
        this.adminAddress = adminAddress;
    }

    public String getAdminTel() {
        return adminTel;
    }

    public void setAdminTel(String adminTel) {
        this.adminTel = adminTel;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPostalCode() {
        return adminPostalCode;
    }

    public void setAdminPostalCode(String adminPostalCode) {
        this.adminPostalCode = adminPostalCode;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    protected Serializable pkVal() {
        return this.uuid;
    }

    @Override
    public String toString() {
        return "FppAdmin{" +
                "uuid=" + uuid +
                ", adminId=" + adminId +
                ", adminType=" + adminType +
                ", adminPassword=" + adminPassword +
                ", registrationCode=" + registrationCode +
                ", registrationTime=" + registrationTime +
                ", adminName=" + adminName +
                ", adminRegion=" + adminRegion +
                ", adminIdNumber=" + adminIdNumber +
                ", adminAddress=" + adminAddress +
                ", adminTel=" + adminTel +
                ", adminEmail=" + adminEmail +
                ", adminPostalCode=" + adminPostalCode +
                ", state=" + state +
                "}";
    }
}
