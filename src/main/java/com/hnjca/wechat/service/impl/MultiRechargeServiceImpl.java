package com.hnjca.wechat.service.impl;

import com.hnjca.wechat.dao.MultiConsumeDao;
import com.hnjca.wechat.dao.MultiRechargeDao;
import com.hnjca.wechat.dao.MultiStaffDao;
import com.hnjca.wechat.pojo.MultiConsume;
import com.hnjca.wechat.pojo.MultiRecharge;
import com.hnjca.wechat.pojo.MultiStaff;
import com.hnjca.wechat.pojo.TemplateJson;
import com.hnjca.wechat.service.MultiConsumeService;
import com.hnjca.wechat.service.MultiRechargeService;
import com.hnjca.wechat.service.MultiTerminalService;
import com.hnjca.wechat.util.DateUtil;
import com.hnjca.wechat.util.TemplateMsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-27
 * Time: 11:50
 * Modified:
 */
@Service
public class MultiRechargeServiceImpl implements MultiRechargeService {

    @Autowired
    private MultiRechargeDao multiRechargeDao;
    @Autowired
    private MultiStaffDao multiStaffDao;
    @Autowired
    private MultiTerminalService multiTerminalService;

    @Transactional
    @Override
    public int insertMultiRecharge(MultiRecharge multiRecharge) {
        int ret = multiRechargeDao.insertMultiRecharge(multiRecharge);
        /**
         * 员工的工号
         */
        String jobNo = multiRecharge.getEmpId();
        /**
         * 企业编码
         */
        String eCode = multiRecharge.getECode();
        Map<String, Object> map = new HashMap<>();
        map.put("eCode", eCode);
        map.put("jobNo", jobNo);
        MultiStaff multiStaff = multiStaffDao.selectByCondition(map);
        String openId = multiStaff.getOpenId();
        if (multiStaff != null && openId != null && !openId.trim().equals("")) {
            /**
             * 如果用户不为空，并且已经绑定openid，就发送模板消息
             */
            TemplateJson templateJson = new TemplateJson();
            templateJson.setTouser(openId);
            templateJson.setTemplate_id("oyXE8Q0W79G_oFJ5o6IqGx7572wwwfqPJ4VvmIS62Nw");
            templateJson.setUrl("http://llison.viphk.ngrok.org/api/info_1.html?t=2");
            templateJson.setDataFirstValue("您有一条饭卡充值成功消息");
            templateJson.setDataKeyWord1Value(multiRecharge.getCardId());//充值账号
            templateJson.setDataKeyWord2Value(multiStaff.getSName());//姓名
            templateJson.setDataKeyWord3Value(multiRecharge.getChargeMoney());//充值余额
            templateJson.setDataKeyWord4Value(DateUtil.dateToStr(multiRecharge.getOpDate(), null));//充值时间
            templateJson.setDataKeyWord5Value(multiRecharge.getCardBalance());//充值余额
            templateJson.setDataRemarkValue("点击详情可查看更多信息");
            boolean result = TemplateMsgUtil.sendTemplateMsg(templateJson);
            if (result) {
                return 100;//表示数据同步成功，发送消息成功
            } else {
                return 101;//表示数据同步成功，但是发送模板消息失败
            }

        }
        return ret;

    }

    @Override
    public MultiRecharge selectOneByCondition(Map<String, Object> map) {
        return this.multiRechargeDao.selectOneByCondition(map);
    }
    @Override
    public List<MultiRecharge> selectCList(String jobNo, String openId,String month) {
        return this.multiRechargeDao.selectCList(jobNo,openId,month);
    }
}
