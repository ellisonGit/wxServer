package com.hnjca.wechat.service.impl;

import com.hnjca.wechat.dao.MultiTreminalDao;
import com.hnjca.wechat.pojo.MultiTerminal;
import com.hnjca.wechat.service.MultiTerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-27
 * Time: 11:54
 * Modified:
 */
@Service
public class MultiTerminalServiceImpl implements MultiTerminalService {

    @Autowired
    private MultiTreminalDao multiTreminalDao;

    @Override
    public int insertMultiTerminal(MultiTerminal multiTerminal) {
        try{
            this.multiTreminalDao.insertMultiTerminal(multiTerminal);
            return 0;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public int countByCondition(String eCode) {
        return this.multiTreminalDao.countByCondition(eCode);
    }

    @Override
    public int deleteByEcode(String eCode) {
        try{
            this.multiTreminalDao.deleteByEcode(eCode);
            return 0;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return -1;
        }
    }

    @Override
    public String selectNameByNo(String eCode,String tNo) {
        Map<String,Object> map = new HashMap<>();
        map.put("eCode",eCode);
        map.put("tNo",tNo);
        return this.multiTreminalDao.selectNameByNo(map);
    }
}
