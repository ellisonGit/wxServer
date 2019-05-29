package com.hnjca.wechat.service.impl;

import com.hnjca.wechat.dao.MultiRechargeDao;
import com.hnjca.wechat.dao.MultiStaffDao;
import com.hnjca.wechat.dao.WxMultiRechargeDao;
import com.hnjca.wechat.pojo.MultiRecharge;
import com.hnjca.wechat.pojo.MultiStaff;
import com.hnjca.wechat.pojo.TemplateJson;
import com.hnjca.wechat.pojo.WxMultiRecharge;
import com.hnjca.wechat.service.MultiRechargeService;
import com.hnjca.wechat.service.MultiTerminalService;
import com.hnjca.wechat.service.WxMultiRechargeService;
import com.hnjca.wechat.util.DateUtil;
import com.hnjca.wechat.util.TemplateMsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * User: Ellison
 * Date: 2019-05-27
 * Time: 11:50
 * Modified:
 */
@Service
public class WxMultiRechargeServiceImpl implements WxMultiRechargeService {

    @Autowired
    private WxMultiRechargeDao wxMultiRechargeDao;
    @Autowired
    private MultiStaffDao multiStaffDao;


    @Transactional
    @Override
    public int insertWxMultiRecharge(WxMultiRecharge wxMultiRecharge) {
        return  wxMultiRechargeDao.insertWxMultiRecharge(wxMultiRecharge);
    }

    @Transactional
    @Override
    public WxMultiRecharge selectOne( String openId,String eCode,String uid) {
        return  wxMultiRechargeDao.selectOne(openId,eCode,uid);



    }

}
