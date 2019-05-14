package com.hnjca.wechat.pojo;

import lombok.Data;

/**
 * Description: 部门 对应数据库multi_departs表
 * User: YangYong
 * Date: 2019-04-26
 * Time: 16:15
 * Modified:
 */
@Data
public class MultiDeparts {

    /**
     * 部门编号
     */
    private String departId ;

    /**
     * 部门标识
     */
    private String insideId ;

    /**
     * 分组标识
     */
    private String groupId ;

    /**
     * 部门名称
     */
    private String departName ;

    /**
     * 部门负责人
     */
    private String principal;

    /**
     * 工号前缀
     */
    private String empPrefix ;

    /**
     * 企业编码
     */
    private String eCode ;
}
