package com.hnjca.wechat.dao;

import com.hnjca.wechat.pojo.MultiStaff;
import com.hnjca.wechat.pojo.WxcpMultiStaff;

import java.util.Map;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-26
 * Time: 10:10
 * Modified:
 */
public interface WxcpMultiStaffDao {

    void insertMultiStaff(WxcpMultiStaff wxcpMultiStaff);

    int countByEcode(Map<String, Object> map);

    void deleteByEcode(Map<String, Object> map);

    WxcpMultiStaff selectByCondition(Map<String, Object> map);

    int selectOpenid(WxcpMultiStaff wxcpMultiStaff);

    int updateOpenid(WxcpMultiStaff wxcpMultiStaff);

    int selectUser(WxcpMultiStaff wxcpMultiStaff);

    String findOpenId(String openId);

    WxcpMultiStaff selectUserInfo(String openId);

}
