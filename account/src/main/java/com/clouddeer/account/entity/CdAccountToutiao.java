package com.clouddeer.account.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 授权账户-头条表
 *
 * @author clouddeer
 * @email cd@clouddeer.com
 * @date 2018-06-13 15:27:02
 */
@Table(name = "cd_account_toutiao")
public class CdAccountToutiao implements Serializable {
    private static final long serialVersionUID = 1L;

    //主键
    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    //授权账户id
    @Column(name = "account_id")
    private Integer accountId;

    //粉丝数
    @Column(name = "followers_count")
    private Integer followersCount;

    //发布数量
    @Column(name = "publish_count")
    private Integer publishCount;

    //阅读次数
    @Column(name = "read_count")
    private Integer readCount;

    //创建时间
    @Column(name = "create_date")
    private Date createDate;

    //创建人id
    @Column(name = "create_user_id")
    private Integer createUserId;

    //更新时间
    @Column(name = "update_date")
    private Date updateDate;

    //更新人id
    @Column(name = "update_user_id")
    private Integer updateUserId;

    //是否有效：0 无效，1 有效
    @Column(name = "record_status")
    private Integer recordStatus;


    /**
     * 设置：主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置：授权账户id
     */
    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    /**
     * 获取：授权账户id
     */
    public Integer getAccountId() {
        return accountId;
    }

    /**
     * 设置：粉丝数
     */
    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }

    /**
     * 获取：粉丝数
     */
    public Integer getFollowersCount() {
        return followersCount;
    }

    /**
     * 设置：发布数量
     */
    public void setPublishCount(Integer publishCount) {
        this.publishCount = publishCount;
    }

    /**
     * 获取：发布数量
     */
    public Integer getPublishCount() {
        return publishCount;
    }

    /**
     * 设置：阅读次数
     */
    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    /**
     * 获取：阅读次数
     */
    public Integer getReadCount() {
        return readCount;
    }

    /**
     * 设置：创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取：创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置：创建人id
     */
    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * 获取：创建人id
     */
    public Integer getCreateUserId() {
        return createUserId;
    }

    /**
     * 设置：更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取：更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置：更新人id
     */
    public void setUpdateUserId(Integer updateUserId) {
        this.updateUserId = updateUserId;
    }

    /**
     * 获取：更新人id
     */
    public Integer getUpdateUserId() {
        return updateUserId;
    }

    /**
     * 设置：是否有效：0 无效，1 有效
     */
    public void setRecordStatus(Integer recordStatus) {
        this.recordStatus = recordStatus;
    }

    /**
     * 获取：是否有效：0 无效，1 有效
     */
    public Integer getRecordStatus() {
        return recordStatus;
    }
}
