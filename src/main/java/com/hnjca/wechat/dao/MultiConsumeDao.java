package com.hnjca.wechat.dao;

import com.hnjca.wechat.pojo.MultiConsume;
import java.util.Map;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-26
 * Time: 9:37
 * Modified:
 */
public interface MultiConsumeDao {

    void insertMultiConsume(MultiConsume multiConsume);

    MultiConsume selectOneByCondition(Map<String,Object> map);
}
