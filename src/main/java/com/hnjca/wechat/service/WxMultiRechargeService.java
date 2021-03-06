package com.hnjca.wechat.service;

import com.github.pagehelper.PageInfo;
import com.hnjca.wechat.pojo.MultiRecharge;
import com.hnjca.wechat.pojo.WxMultiRecharge;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * User: Ellison
 * Date: 2019-05-26
 * Time: 11:44
 * Modified:
 */
public interface WxMultiRechargeService {


  int insertWxMultiRecharge(WxMultiRecharge wxMultiRecharge);
  WxMultiRecharge selectOne(String openId,String eCode,String uid);
  List<WxMultiRecharge> selectIf(String eCode);
  int updateState(WxMultiRecharge wxMultiRecharge);
  //test 分页
  PageInfo<WxMultiRecharge> selectFy(WxMultiRecharge wxMultiRecharge);
}
