package com.hnjca.wechat.pojo;

import lombok.Data;

import java.util.Date;

/**
 * Description: 充值记录 对应数据库MULTI_RECHARGE表
 * User: Ellison
 * Date: 2019-05-16
 * Time: 8:56
 * Modified:
 */
@Data
public class MultiRecharge {

    private Integer cid ;
    private String empId ;

    private String cardId ;

    private String chargeMoney ;

    private String cardBalance ;

    private Date opYmd ;

    private String cardTimes ;

    private String cardSequ ;

    private String Kind ;

    private String opUser ;

    private Date opDate ;

    private String remark;

    private String difineSequ;

    private String eCode;


    //附加
    private String money ;

    private Date createTime ;




}
