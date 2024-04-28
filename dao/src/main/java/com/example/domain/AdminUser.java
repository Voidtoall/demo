package com.example.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author zyh
 * @since 2024-04-26 ��:��:��
 */
@EqualsAndHashCode(callSuper = true)
@TableName("admin_user")
@Data
public class AdminUser extends BasePo implements Serializable {


    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 帐号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 用户名
     */
    private String username;

    /**
     * 添加时间
     */
    private LocalDateTime createTime;

    /**
     * 最后登录时间
     */
    private LocalDateTime lastLoginTime;

    private LocalDateTime timestamp;

    /**
     * 其他状态
     */
    private Byte status;

    /**
     * 0:有效 1:禁止登录
     */
    private Boolean isDisable;

    /**
     * 1:删除，0:未删除
     */
    private Boolean isDelete;

    /**
     * 父级管理员id
     */
    private Long adminParentId;

    /**
     * 父级分销代理商id
     */
    private Long agentParentId;

    /**
     * 代理商邀请码
     */
    private String userInviteCode;

    /**
     * 推荐邀请关系树
     */
    private String invitationPath;

    /**
     * 审核状态(1-待审核;2-已审核;3-拒绝)
     */
    private Byte inspectStatus;


    @Override
    public String toString() {
        return "AdminUser{" +
        "id = " + id +
        ", account = " + account +
        ", password = " + password +
        ", nickname = " + nickname +
        ", username = " + username +
        ", createTime = " + createTime +
        ", lastLoginTime = " + lastLoginTime +
        ", timestamp = " + timestamp +
        ", status = " + status +
        ", isDisable = " + isDisable +
        ", isDelete = " + isDelete +
        ", adminParentId = " + adminParentId +
        ", agentParentId = " + agentParentId +
        ", userInviteCode = " + userInviteCode +
        ", invitationPath = " + invitationPath +
        ", inspectStatus = " + inspectStatus +
        "}";
    }
}
