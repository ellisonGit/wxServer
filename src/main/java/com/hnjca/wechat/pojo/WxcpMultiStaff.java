package com.hnjca.wechat.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Description: 人员信息 对应数据库wxcp_multi_staff表
 * User: Ellison
 * Date: 2019-06-11
 * Time: 16:31
 * Modified:
 */
@Data
public class WxcpMultiStaff {

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

    private String userId ;

}
