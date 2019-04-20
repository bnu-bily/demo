package com.patent.demo.entity;

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
public class FppAccountKeyCenter extends Model<FppAccountKeyCenter> {


    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    @TableId
    private String uuid;
    /**
     * 私钥
     */
    @TableField
    private String privateKey;
    /**
     * 公钥
     */
    @TableField
    private String publicKey;
    /**
     * 加密方式
     */
    @TableField
    private String signType;
    /**
     * 备注
     */
    @TableField
    private String annex;

    public FppAccountKeyCenter() {

    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
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
        return "FppAccountKeyCenter{" +
                "uuid=" + uuid +
                ", privateKey=" + privateKey +
                ", publicKey=" + publicKey +
                ", signType=" + signType +
                ", annex=" + annex +
                "}";
    }
}
