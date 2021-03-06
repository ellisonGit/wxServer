package com.hnjca.wechat.dao;

import com.hnjca.wechat.pojo.WxMultiRecharge;

import java.util.List;


/**
 * Description:
 * User: Ellison
 * Date: 2019-05-28
 * Time: 8:56
 * Modified:
 */
public interface WxMultiRechargeDao {

    int insertWxMultiRecharge(WxMultiRecharge wxMultiRecharge);
    WxMultiRecharge selectOne(String openId,String eCode,String uid);
    List<WxMultiRecharge> selectIf(String eCode);
    int updateState(WxMultiRecharge wxMultiRecharge);

    List<WxMultiRecharge> selectFy(WxMultiRecharge wxMultiRecharge);

}
