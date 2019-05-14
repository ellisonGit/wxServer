package com.hnjca.wechat.service.impl;

import com.hnjca.wechat.dao.MultiDepartsDao;
import com.hnjca.wechat.pojo.MultiDeparts;
import com.hnjca.wechat.service.MultiDepartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-27
 * Time: 11:51
 * Modified:
 */
@Service
public class MultiDepartsServiceImpl implements MultiDepartsService {

    @Autowired
    private MultiDepartsDao multiDepartsDao;

    @Override
    public int insertMultiDeparts(MultiDeparts multiDeparts) {
        try{
            this.multiDepartsDao.insertMultiDeparts(multiDeparts);
            return 0;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return  -1;
        }
    }

    @Override
    public int countByEcode(String eCode) {
        return this.multiDepartsDao.countByEcode(eCode);
    }

    @Override
    public int deleteByEcode(String eCode) {
        try{
            this.multiDepartsDao.deleteByEcode(eCode);
            return 0;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }
}
