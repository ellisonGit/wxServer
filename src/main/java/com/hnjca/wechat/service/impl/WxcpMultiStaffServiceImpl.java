package com.hnjca.wechat.service.impl;

import com.hnjca.wechat.dao.MultiStaffDao;
import com.hnjca.wechat.dao.WxcpMultiStaffDao;
import com.hnjca.wechat.pojo.MultiStaff;
import com.hnjca.wechat.pojo.WxcpMultiStaff;
import com.hnjca.wechat.service.MultiStaffService;
import com.hnjca.wechat.service.WxcpMultiStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: Ellison
 * Date: 2019-06-11
 * Time: 11:53
 * Modified:
 */
@Service
public class WxcpMultiStaffServiceImpl implements WxcpMultiStaffService {

    @Autowired
    private WxcpMultiStaffDao wxcpMultiStaffDao;

    @Override
    public int insertMultiStaff(WxcpMultiStaff wxcpMultiStaff) {
        try{
            this.wxcpMultiStaffDao.insertMultiStaff(wxcpMultiStaff);
            return 0;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public int countByEcode(String eCode) {
        Map<String,Object> map = new HashMap<>();
        map.put("eCode",eCode);
        return this.wxcpMultiStaffDao.countByEcode(map);
    }

    @Override
    public int deleteByEcode(String eCode) {
        try{
            Map<String,Object> map = new HashMap<>();
            map.put("eCode",eCode);
            this.wxcpMultiStaffDao.deleteByEcode(map);
            return 0;
        }catch (Exception e){
            return -1;
        }
    }
//根据工号和姓名查询openid
    @Override
    public int selectOpenid(WxcpMultiStaff wxcpMultiStaff) {
        try{
            return wxcpMultiStaffDao.selectOpenid(wxcpMultiStaff);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    //根据工号和姓名查询是否存在该员工信息
    @Override
    public int selectUser(WxcpMultiStaff wxcpMultiStaff) {
        try{
            return wxcpMultiStaffDao.selectUser(wxcpMultiStaff);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    //根据工号和姓名绑定openid
    @Override
    public int updateOpenid(WxcpMultiStaff wxcpMultiStaff) {
            return wxcpMultiStaffDao.updateOpenid( wxcpMultiStaff);
    }

    //根据openid查是否存在
    @Override
    public String findOpenId(String openId) {
        return wxcpMultiStaffDao.findOpenId( openId);
    }

    //根据openid查是否存在
    @Override
    public WxcpMultiStaff selectUserInfo(String openId) {
        return wxcpMultiStaffDao.selectUserInfo( openId);
    }


}
