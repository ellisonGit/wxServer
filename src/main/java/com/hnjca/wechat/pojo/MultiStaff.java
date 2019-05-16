package com.hnjca.wechat.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Description: 人员信息 对应数据库multi_staff表
 * User: YangYong
 * Date: 2019-04-25
 * Time: 16:31
 * Modified:
 */
@Data
public class MultiStaff {

    private Integer sid ;

    private String sName ;

    private String eCode ;

    private String departsId;

    private String openId ;

    private String telNo ;

    //标记（0：未同步，1已同步）
    private String avatar ;

    private Date createTime ;

    private Date lastTime ;

    private String jobNo;

    private String cardNo ;
}
