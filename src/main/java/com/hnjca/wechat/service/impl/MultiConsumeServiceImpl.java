package com.hnjca.wechat.service.impl;

import com.hnjca.wechat.dao.MultiConsumeDao;
import com.hnjca.wechat.dao.MultiStaffDao;
import com.hnjca.wechat.pojo.MultiConsume;
import com.hnjca.wechat.pojo.MultiStaff;
import com.hnjca.wechat.pojo.TemplateJson;
import com.hnjca.wechat.service.MultiConsumeService;
import com.hnjca.wechat.service.MultiTerminalService;
import com.hnjca.wechat.util.DateUtil;
import com.hnjca.wechat.util.TemplateMsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 * User: YangYong
 * Date: 2019-04-27
 * Time: 11:50
 * Modified:
 */
@Service
public class MultiConsumeServiceImpl implements MultiConsumeService {

    @Autowired
    private MultiConsumeDao multiConsumeDao;

    @Autowired
    private MultiStaffDao multiStaffDao;

    @Autowired
    private MultiTerminalService multiTerminalService;

    @Transactional
    @Override
    public int insertMultiConsume(MultiConsume multiConsume) {
        try{
            this.multiConsumeDao.insertMultiConsume(multiConsume);

            /**
             * 员工的工号
             */
            String jobNo = multiConsume.getJobNo();
            /**
             * 企业编码
             */
            String eCode = multiConsume.getECode();
            Map<String,Object> map = new HashMap<>();
            map.put("eCode",eCode);
            map.put("jobNo",jobNo);
            MultiStaff multiStaff = multiStaffDao.selectByCondition(map);

            String openId = multiStaff.getOpenId();
            if(multiStaff != null && openId != null && !openId.trim().equals("")){
                /**
                 * 如果用户不为空，并且已经绑定openid，就发送模板消息
                 */
                TemplateJson templateJson = new TemplateJson();
                templateJson.setTouser(openId);
                templateJson.setTemplate_id("usuiSNnSjbVXr3eqcCYC81G0bXMSYG587gE1Ri6gv5U");
                templateJson.setUrl("http://www.130xxxx5088.com/test/info_1.html?t=2");
                templateJson.setDataFirstValue("您好，"+multiStaff.getSName()+"的校园卡刚进行了一笔消费");
                templateJson.setDataKeyWord1Value(String.valueOf(multiConsume.getMoney()));

                /**
                 * 获取设备名称
                 */
                String tName = multiTerminalService.selectNameByNo(eCode,multiConsume.getTNo());
                templateJson.setDataKeyWord2Value(tName);

                templateJson.setDataKeyWord3Value(DateUtil.dateToStr(multiConsume.getCreateTime(),null));
                templateJson.setDataKeyWord4Value(String.valueOf(multiConsume.getRemainMoney()));
                templateJson.setDataRemarkValue("点击详情可查看更多信息");

                boolean result = TemplateMsgUtil.sendTemplateMsg(templateJson);
                if(result){
                    return 100;//表示数据同步成功，发送消息成功
                }else{
                    return 101;//表示数据同步成功，但是发送模板消息失败
                }
            }
            return 0;
        }catch (Exception e){
            return -1;
        }
    }

    @Override
    public MultiConsume selectOneByCondition(Map<String, Object> map) {
        return this.multiConsumeDao.selectOneByCondition(map);
    }
}
