package com.hnjca.wechat.service.impl;


import com.github.pagehelper.PageInfo;
import com.hnjca.wechat.dao.MultiStaffDao;
import com.hnjca.wechat.dao.WxMultiRechargeDao;
import com.hnjca.wechat.pojo.WxMultiRecharge;
import com.hnjca.wechat.service.WxMultiRechargeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


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

    @Transactional
    @Override
    public List<WxMultiRecharge> selectIf( String eCode) {
        return  wxMultiRechargeDao.selectIf(eCode);
    }

    @Transactional
    @Override
    public int updateState( WxMultiRecharge wxMultiRecharge) {
        return  wxMultiRechargeDao.updateState(wxMultiRecharge);
    }



   @Override
    public PageInfo<WxMultiRecharge> selectFy(WxMultiRecharge wxMultiRecharge) {
       List<WxMultiRecharge> rows = wxMultiRechargeDao.selectFy(wxMultiRecharge);
       PageInfo<WxMultiRecharge> pageInfo = new PageInfo<WxMultiRecharge>(rows);
       return pageInfo;
    }
}
