package com.hnjca.wechat.service;

import com.hnjca.wechat.pojo.MultiConsume;

import java.util.Map;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-27
 * Time: 11:44
 * Modified:
 */
public interface MultiConsumeService {

    int insertMultiConsume(MultiConsume multiConsume);

    MultiConsume selectOneByCondition(Map<String,Object> map);
}
