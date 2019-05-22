package com.hnjca.wechat.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Description: 消费记录 对应数据库multi_consume表
 * User: YangYong
 * Date: 2019-04-26
 * Time: 8:56
 * Modified:
 */
@Data
public class MultiConsume {

    private Integer cid ;

    private String money ;

    private String remainMoney ;

    private String consumeType ;

    private Date createTime ;

    private String createIp ;

    private String poseSequ ;

    private String cardSequ ;

    private String tNo ;

    private String eCode ;

    private String jobNo;

    private String cardNo;




}
