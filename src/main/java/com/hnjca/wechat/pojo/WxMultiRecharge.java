package com.hnjca.wechat.pojo;

import lombok.Data;
import org.springframework.data.annotation.Transient;

import java.util.Date;

/**
 * Description: 微信充值记录 对应数据库WX_MULTI_RECHARGE表
 * User: Ellison
 * Date: 2019-05-27
 * Time: 8:56
 * Modified:
 */
@Data
public class WxMultiRecharge {

    private String pageSize;

    private String pageNumber;
    private String uid ;
    private String money ;

    private String remainMoney ;

    private String state ;

    private Date createTime ;

    private String openId ;

    private String poseSequ ;

    private String cardSequ ;

    private String eCode ;

    private String JobNo ;

    private String cardNo ;

    private String outTradeNo;

    //附加
    private  String body;

    private  String empId;



}
