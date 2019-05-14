package com.hnjca.wechat.dao;

import com.hnjca.wechat.pojo.MultiTerminal;

import java.util.Map;


/**
 * Description:
 * User: YangYong
 * Date: 2019-04-26
 * Time: 9:17
 * Modified:
 */
public interface MultiTreminalDao {

    void insertMultiTerminal(MultiTerminal multiTerminal);

    int countByCondition(String eCode);

    void deleteByEcode(String eCode);

    String selectNameByNo(Map<String,Object> map);
}
