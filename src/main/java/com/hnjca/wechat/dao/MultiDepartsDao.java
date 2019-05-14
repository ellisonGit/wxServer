package com.hnjca.wechat.dao;


import com.hnjca.wechat.pojo.MultiDeparts;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-26
 * Time: 10:10
 * Modified:
 */
public interface MultiDepartsDao {

    void insertMultiDeparts(MultiDeparts multiDeparts);

    int countByEcode(String eCode);

    void deleteByEcode(String eCode);
}
