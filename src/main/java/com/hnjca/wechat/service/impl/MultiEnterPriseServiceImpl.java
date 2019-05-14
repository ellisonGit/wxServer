package com.hnjca.wechat.service.impl;

import com.hnjca.wechat.dao.MultiEnterPriseDao;
import com.hnjca.wechat.pojo.MultiEnterprise;
import com.hnjca.wechat.service.MultiEnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-27
 * Time: 11:52
 * Modified:
 */
@Service
public class MultiEnterPriseServiceImpl implements MultiEnterpriseService {

    @Autowired
    private MultiEnterPriseDao multiEnterPriseDao;

    @Override
    public MultiEnterprise selectOneByCondition(Map<String, Object> map) {
        return this.multiEnterPriseDao.selectOneByCondition(map);
    }
}
