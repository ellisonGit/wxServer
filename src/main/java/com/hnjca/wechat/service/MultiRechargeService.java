package com.hnjca.wechat.service;

import com.hnjca.wechat.pojo.MultiConsume;
import com.hnjca.wechat.pojo.MultiRecharge;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * User: Ellison
 * Date: 2019-05-16
 * Time: 11:44
 * Modified:
 */
public interface MultiRechargeService {

  MultiRecharge selectOneByCondition(Map<String,Object> map);

  int insertMultiRecharge(MultiRecharge multiRecharge);

  List<MultiRecharge> selectCList(String jobNo, String openId ,String month);
}
