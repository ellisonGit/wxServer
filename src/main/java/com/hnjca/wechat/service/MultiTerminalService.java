package com.hnjca.wechat.service;

import com.hnjca.wechat.pojo.MultiTerminal;

import java.util.Map;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-27
 * Time: 11:49
 * Modified:
 */
public interface MultiTerminalService {

    int insertMultiTerminal(MultiTerminal multiTerminal);

    int countByCondition(String eCode);

    int deleteByEcode(String eCode);

    String selectNameByNo(String eCode,String TNo);
}

