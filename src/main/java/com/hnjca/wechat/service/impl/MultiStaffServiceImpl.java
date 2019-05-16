package com.hnjca.wechat.service.impl;

import com.hnjca.wechat.dao.MultiStaffDao;
import com.hnjca.wechat.pojo.MultiStaff;
import com.hnjca.wechat.service.MultiStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-27
 * Time: 11:53
 * Modified:
 */
@Service
public class MultiStaffServiceImpl implements MultiStaffService {

    @Autowired
    private MultiStaffDao multiStaffDao;

    @Override
    public int insertMultiStaff(MultiStaff multiStaff) {
        try{
            this.multiStaffDao.insertMultiStaff(multiStaff);
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
        return this.multiStaffDao.countByEcode(map);
    }

    @Override
    public int deleteByEcode(String eCode) {
        try{
            Map<String,Object> map = new HashMap<>();
            map.put("eCode",eCode);
            this.multiStaffDao.deleteByEcode(map);
            return 0;
        }catch (Exception e){
            return -1;
        }
    }
//根据工号和姓名查询openid
    @Override
    public int selectOpenid(MultiStaff multiStaff) {
        try{
            return multiStaffDao.selectOpenid(multiStaff);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    //根据工号和姓名查询是否存在该员工信息
    @Override
    public int selectUser(MultiStaff multiStaff) {
        try{
            return multiStaffDao.selectUser(multiStaff);

        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    //根据工号和姓名绑定openid
    @Override
    public int updateOpenid(MultiStaff multiStaff) {
            return multiStaffDao.updateOpenid( multiStaff);
    }

    //根据openid查是否存在
    @Override
    public String findOpenId(String openId) {
        return multiStaffDao.findOpenId( openId);
    }

    //根据openid查是否存在
    @Override
    public MultiStaff selectUserInfo(String openId) {
        return multiStaffDao.selectUserInfo( openId);
    }


}
