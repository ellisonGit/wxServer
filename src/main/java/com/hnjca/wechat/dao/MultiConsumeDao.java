package com.hnjca.wechat.dao;

import com.hnjca.wechat.pojo.MultiConsume;

import java.util.List;
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

    String selectYuE(String jobNo,String openId);

    MultiConsume selectSum(String jobNo,String openId,String month);

    List<MultiConsume> selectXList(String jobNo, String openId,String month);
}
