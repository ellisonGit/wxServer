package com.hnjca.wechat.pojo;

import lombok.Data;

/**
 * Description: 设备终端 对应数据库 multi_terminal表
 * User: YangYong
 * Date: 2019-04-25
 * Time: 16:36
 * Modified:
 */
@Data
public class MultiTerminal {

    private Integer tid ;

    private String tName ;

    private String tNo ;

    private Integer tType ;

    private String eCode ;
}
