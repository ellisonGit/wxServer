package com.hnjca.wechat.service;

import com.hnjca.wechat.pojo.MultiEnterprise;

import java.util.Map;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-27
 * Time: 11:49
 * Modified:
 */
public interface MultiEnterpriseService {

    MultiEnterprise selectOneByCondition(Map<String,Object> map);
}
