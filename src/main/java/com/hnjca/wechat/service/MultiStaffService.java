package com.hnjca.wechat.service;

import com.hnjca.wechat.pojo.MultiStaff;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-27
 * Time: 11:49
 * Modified:
 */
public interface MultiStaffService {

    int insertMultiStaff(MultiStaff multiStaff);

    int countByEcode(String eCode);

    int deleteByEcode(String eCode);
}
