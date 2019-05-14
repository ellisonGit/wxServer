package com.hnjca.wechat.service;

import com.hnjca.wechat.pojo.MultiDeparts;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-27
 * Time: 11:48
 * Modified:
 */
public interface MultiDepartsService {

    int insertMultiDeparts(MultiDeparts multiDeparts);

    int countByEcode(String eCode);

    int deleteByEcode(String eCode);
}
