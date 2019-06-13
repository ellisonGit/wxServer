package com.hnjca.wechat.service.impl;


import com.github.pagehelper.PageInfo;
import com.hnjca.wechat.dao.MultiStaffDao;
import com.hnjca.wechat.dao.WxCpTokenDao;
import com.hnjca.wechat.dao.WxMultiRechargeDao;
import com.hnjca.wechat.pojo.WxCpToken;
import com.hnjca.wechat.pojo.WxMultiRecharge;
import com.hnjca.wechat.service.WxCpTokenService;
import com.hnjca.wechat.service.WxMultiRechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


/**
 * Description:
 * User: Ellison
 * Date: 2019-05-27
 * Time: 11:50
 * Modified:
 */
@Service
public class WxCpTokenServiceImpl implements WxCpTokenService {

    @Autowired
    private WxCpTokenDao wxCpTokenDao;





    @Transactional
    @Override
    public int updateToken(String accessToken , Date tokenTime) {
        return  wxCpTokenDao.updateToken(accessToken,tokenTime);
    }

      @Transactional
    @Override
    public WxCpToken selectOne() {
        return  wxCpTokenDao.selectOne();
    }




}
