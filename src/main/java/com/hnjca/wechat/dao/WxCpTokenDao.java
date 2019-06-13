package com.hnjca.wechat.dao;

import com.hnjca.wechat.pojo.WxCpToken;
import com.hnjca.wechat.pojo.WxMultiRecharge;

import java.util.Date;
import java.util.List;


/**
 * Description:
 * User: Ellison
 * Date: 2019-05-28
 * Time: 8:56
 * Modified:
 */
public interface WxCpTokenDao {

    WxCpToken selectOne();
    int updateToken(String accessToken, Date tokenTime);


}
