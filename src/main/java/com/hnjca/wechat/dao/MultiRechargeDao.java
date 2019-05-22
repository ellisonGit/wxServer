package com.hnjca.wechat.dao;

import com.hnjca.wechat.pojo.MultiRecharge;
import com.hnjca.wechat.pojo.MultiStaff;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * User: Ellison
 * Date: 2019-05-16
 * Time: 8:56
 * Modified:
 */
public interface MultiRechargeDao {

    MultiRecharge selectOneByCondition(Map<String,Object> map);

    int insertMultiRecharge(MultiRecharge multiRecharge);

    List<MultiRecharge> selectCList(String jobNo, String openId ,String month);

}
