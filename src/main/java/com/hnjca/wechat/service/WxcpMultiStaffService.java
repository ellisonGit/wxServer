package com.hnjca.wechat.service;

import com.hnjca.wechat.pojo.MultiStaff;
import com.hnjca.wechat.pojo.WxcpMultiStaff;

/**
 * Description:
 * User: Ellison
 * Date: 2019-06-11
 * Time: 11:49
 * Modified:
 */
public interface WxcpMultiStaffService {

    int insertMultiStaff(WxcpMultiStaff wxcpMultiStaff);

    int countByEcode(String eCode);

    int deleteByEcode(String eCode);

    int selectOpenid(WxcpMultiStaff wxcpMultiStaff);

    int updateOpenid(WxcpMultiStaff wxcpMultiStaff);

    int selectUser(WxcpMultiStaff wxcpMultiStaff);

    String findOpenId(String openId);

    WxcpMultiStaff selectUserInfo(String openId);
}
