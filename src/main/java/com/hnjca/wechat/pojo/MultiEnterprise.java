package com.hnjca.wechat.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Description: 企业表 对应数据库 multi_enterprise
 * User: YangYong
 * Date: 2019-04-25
 * Time: 16:21
 * Modified:
 */
@Data
public class MultiEnterprise {

    private Integer eid ;

    private String eName ;

    private String eCode ;

    private String eDescribe;

    private String eType ;

    private String appId ;

    private String secret ;

    private String token ;

    private Date createTime ;
}
