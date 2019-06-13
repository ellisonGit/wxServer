package com.hnjca.wechat.service;


import com.hnjca.wechat.pojo.WxCpToken;

import java.util.Date;

/**
 * Description:
 * User: Ellison
 * Date: 2019-05-26
 * Time: 11:44
 * Modified:
 */
public interface WxCpTokenService {

  WxCpToken selectOne();
  int updateToken(String accessToken, Date tokenTime);
}
