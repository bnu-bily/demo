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
public class FppLoginLogout extends Model<FppLoginLogout> {


    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识(hashStr(userId + userName + currentTime))
     */
    @TableId
    private String uuid;
    /**
     * 账号登录id
     */
    @TableField
    private String accountId;
    /**
     * 账号登录姓名
     */
    @TableField
    private String accountName;
    /**
     * 登录类型:1普通用户登入；2管理员登入；3普通用户登出；4管理员登出
     */
    @TableField
    private Integer accountType;
    /**
     * 登录时间
     */
    @TableField
    private Date loginTime;
    /**
     * 登出时间
     */
    @TableField
    private Date logoutTime;

    public FppLoginLogout() {
    }

    public FppLoginLogout(String userId, String userName) {
        this.accountId = userId;
        this.accountName = userName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Integer getAccountType() {
        return accountType;
    }

    public void setAccountType(Integer accountType) {
        this.accountType = accountType;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.uuid;
    }

    @Override
    public String toString() {
        return "FppLoginLogout{" +
                "uuid=" + uuid +
                ", accountId=" + accountId +
                ", accountName=" + accountName +
                ", accountType=" + accountType +
                ", loginTime=" + loginTime +
                ", logoutTime=" + logoutTime +
                "}";
    }
}
