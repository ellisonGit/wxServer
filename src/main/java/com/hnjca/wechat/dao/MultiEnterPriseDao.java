package com.hnjca.wechat.dao;

import com.hnjca.wechat.pojo.MultiEnterprise;

import java.util.List;
import java.util.Map;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-26
 * Time: 9:37
 * Modified:
 */
public interface MultiEnterPriseDao {

    MultiEnterprise selectOneByCondition(Map<String,Object> map);


}
