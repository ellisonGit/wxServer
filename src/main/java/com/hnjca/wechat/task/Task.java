package com.hnjca.wechat.task;

import com.hnjca.wechat.constant.WechatAccount;
import com.hnjca.wechat.util.AccessTokenUtil;
import com.hnjca.wechat.util.WxServerUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Description:
 * User: YangYong
 * Date: 2019-03-26
 * Time: 15:40
 * Modified:
 */
@Component
public class Task {

    //@Scheduled(cron="0 1 * * * ?")   //每一小时的第一分钟执行一次
    public void getAccessTokenProduction() {
        String token = WxServerUtil.getAccessToken(WechatAccount.HNJCA.getAppId(), WechatAccount.HNJCA.getSecret());
        AccessTokenUtil.accessToken.setAccess_token(token);
        System.out.println("---------------------");
        System.out.println("获取到的token是："+token);
        System.out.println("---------------------");
    }

}
