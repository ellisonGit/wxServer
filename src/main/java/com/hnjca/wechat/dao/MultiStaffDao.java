package com.hnjca.wechat.dao;

import com.hnjca.wechat.pojo.MultiStaff;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-26
 * Time: 10:10
 * Modified:
 */
public interface MultiStaffDao {

    void insertMultiStaff(MultiStaff multiStaff);

    int countByEcode(Map<String,Object> map);

    void deleteByEcode(Map<String,Object> map);

    MultiStaff selectByCondition(Map<String,Object> map);

    int selectOpenid(MultiStaff multiStaff);

    int updateOpenid(MultiStaff multiStaff);

    int selectUser(MultiStaff multiStaff);

    String findOpenId(String openId);

    MultiStaff selectUserInfo(String openId);

}
