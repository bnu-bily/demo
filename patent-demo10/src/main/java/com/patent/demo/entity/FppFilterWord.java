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
public class FppFilterWord extends Model<FppFilterWord> {


    private static final long serialVersionUID = 1L;

    /**
     * 唯一标识
     */
    @TableId
    private String uuid;
    /**
     * 区分是否存入区块链的过滤关键词
     */
    @TableField
    private String word;
    /**
     * 是否生效，生效为1，不生效为0
     */
    @TableField
    private Integer isEffective;
    @TableField
    private Date startTime;
    @TableField
    private Date endTime;

    public FppFilterWord() {

    }

    public FppFilterWord(String word){
        this.word = word;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getIsEffective() {
        return isEffective;
    }

    public void setIsEffective(Integer isEffective) {
        this.isEffective = isEffective;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.uuid;
    }

    @Override
    public String toString() {
        return "FppFilterWord{" +
                "uuid=" + uuid +
                ", word=" + word +
                ", isEffective=" + isEffective +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                "}";
    }
}
