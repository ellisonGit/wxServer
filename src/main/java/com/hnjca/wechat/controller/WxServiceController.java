package com.hnjca.wechat.controller;

import com.hnjca.wechat.enums.InfoEnum;
import com.hnjca.wechat.pojo.MultiConsume;
import com.hnjca.wechat.pojo.MultiRecharge;
import com.hnjca.wechat.pojo.MultiStaff;
import com.hnjca.wechat.service.MultiConsumeService;
import com.hnjca.wechat.service.MultiRechargeService;
import com.hnjca.wechat.service.MultiStaffService;
import com.hnjca.wechat.util.DateUtil;
import com.hnjca.wechat.vo.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageInfo;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 * User: Ellison
 * Date: 2019-05-15
 * Time: 9:11
 * Modified:
 */
@RestController
@RequestMapping(value = "/wx",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
public class WxServiceController {
    @Autowired
    private MultiStaffService multiStaffService;

    @Autowired
    private MultiConsumeService multiConsumeService;

    @Autowired
    private MultiRechargeService multiRechargeService;
    /**
     * 员工绑定微信公众号
     *
     * @param openid
     * @param stuno
     * @param stuname
     * @return
     */





    @GetMapping(value = "/openIdBanding")
    public ResponseInfo banding(String openid, String stuno, String stuname) {

        if (openid == null || "".equals(openid)) {
            return new ResponseInfo(InfoEnum.NO_OPENID, -1);
        }

        if (stuno == null || ("").equals(stuno)) {
            return new ResponseInfo(InfoEnum.NO_STUNO, -1);
        }

        if (stuname == null || ("").equals(stuname)) {
            return new ResponseInfo(InfoEnum.NO_STUNAME_lowercase, -1);
        }
        MultiStaff multiStaff = new MultiStaff();
        multiStaff.setJobNo(stuno);
        multiStaff.setSName(stuname);
        multiStaff.setOpenId(openid);
        int user = multiStaffService.selectUser(multiStaff);//查询该员工是否存员工信息
        if (user > 0) {
            int result = multiStaffService.selectOpenid(multiStaff);//查询该员工是否存在openid
            if (result > 0) {
                return new ResponseInfo(InfoEnum.OPENID_SUCCESS, result);
            } else {
                int open = multiStaffService.updateOpenid( multiStaff);//绑定openid
                if (open > 0) {
                    return new ResponseInfo(InfoEnum.WXSUCCESS, result);
                }
                return new ResponseInfo(InfoEnum.NO_OPEN, result);

            }
        }
        return new ResponseInfo(InfoEnum.NO_USER, user);
    }


    /**
     * 验证员工是否绑定微信公众号
     *
     * @param openId
     *
     * @return
     */

    @GetMapping(value = "/verificationBanding")
    public ResponseInfo banding(String openId) {

        if (openId == null || "".equals(openId)) {
            return new ResponseInfo(InfoEnum.NO_OPENID, -1);
        }
        String  result= multiStaffService.findOpenId(openId);//查询该员工是否存员工信息
        if (result !=null) {
            return new ResponseInfo(InfoEnum.OPENID_SUCCESS, 1);
            }
                return new ResponseInfo(InfoEnum.NO_OPEN, -1);

            }

    /**
     * 通过openid 获取员工基本信息
     * @param openId
     * @return
     */
    @GetMapping(value = "/userInfo")
    public ResponseInfo queryCardInfo(String openId)  {

        if (openId == null || "".equals(openId)) {
            return new ResponseInfo(InfoEnum.NO_OPENID, -1);
        }
        MultiStaff multiStaff = multiStaffService.selectUserInfo(openId);
        //System.out.println("！");
        return new ResponseInfo(InfoEnum.SUCCESS, multiStaff);

    }

    /**
     * 消费记录分页
     * @param openId
     * @param start
     * @param pageSize
     * @param month
     * @return
     */
    @GetMapping(value = "/consumptionInfoByPage")
    public ResponseInfo queryConsumeByPage(String openId,String start,String pageSize,String month,String type){

        if(openId == null || "".equals(openId)){
            return new ResponseInfo(InfoEnum.NO_OPENID,-1);
        }

        if(start == null || "".equals(start)){
            return new ResponseInfo(InfoEnum.NO_START,-1);
        }

        if(pageSize == null){
            pageSize = "20";
        }

        if(month == null || month.equals("now")){
            month = DateUtil.getMonthStr();
        }

        if(type == null || ("").equals(type)){
            type = "0";
        }

        if(!type.equals("1") || !type.equals("2")){
            type = "0";
        }
         String result="";
        if(result.equals("baocuo")){
            return new ResponseInfo(InfoEnum.NET_ERROR,"网络异常，请检查网络后重试！");
        }else{
            return new ResponseInfo(InfoEnum.SUCCESS,month,result);
        }
    }


    /**
     * 余额
     * @param openId
     * @return
     */
    @GetMapping(value = "/getYuE")
    public ResponseInfo yuE(String openId) {

        if (openId == null || "".equals(openId)) {
            return new ResponseInfo(InfoEnum.NO_OPENID, -1);
        }
        MultiStaff  result= multiStaffService.selectUserInfo(openId);//查询该员工是否存员工信息
        if (result !=null) {
            String jobNo=result.getJobNo();
            String ret=multiConsumeService.selectYuE(jobNo,openId);
            if(ret!=null){
                return new ResponseInfo(InfoEnum.SUCCESS, ret);
            }

        }
        return new ResponseInfo(InfoEnum.NET_ERROR, -1);

    }

    /**
     * 支出，充值
     * @param openId
     * @return
     */
    @GetMapping(value = "/getSum")
    public ResponseInfo getSum(String openId ,String month) {

        if (openId == null || "".equals(openId)) {
            return new ResponseInfo(InfoEnum.NO_OPENID, -1);
        }
        MultiStaff  result= multiStaffService.selectUserInfo(openId);//查询该员工是否存员工信息
        if (result !=null) {
            String jobNo=result.getJobNo();
            MultiConsume ret=multiConsumeService.selectSum(jobNo,openId,month);
            if(ret!=null){
                return new ResponseInfo(InfoEnum.SUCCESS, ret);
            }

        }
        return new ResponseInfo(InfoEnum.SUCCESS, 1);

    }


    /**
     * 列表
     * @param openId
     * @return
     */
    @GetMapping(value = "/getXList")
    public ResponseInfo getXList(String openId,String type,String month) {

        if (openId == null || "".equals(openId)) {
            return new ResponseInfo(InfoEnum.NO_OPENID, -1);
        }
        if (type == "1" || "1".equals(type)) {//消费
            MultiStaff  result= multiStaffService.selectUserInfo(openId);//查询该员工是否存员工信息
            if (result !=null) {
                String jobNo=result.getJobNo();
               List<MultiConsume> ret=multiConsumeService.selectXList(jobNo,openId,month);

                if(ret!=null){
                    return new ResponseInfo(InfoEnum.SUCCESS, ret);
                }

            }
            return new ResponseInfo(InfoEnum.NO_OPENID, -1);
        }
        if (type == "2" || "2".equals(type)) {//充值
            MultiStaff  result= multiStaffService.selectUserInfo(openId);//查询该员工是否存员工信息
            if (result !=null) {
                String jobNo=result.getJobNo();
                List<MultiRecharge> ret=multiRechargeService.selectCList(jobNo,openId,month);

                if(ret!=null){
                    return new ResponseInfo(InfoEnum.SUCCESS, ret);
                }

            }
            return new ResponseInfo(InfoEnum.NO_OPENID, -1);
        }
        if (type == "0" || "0".equals(type)) {//全部类型加载
            MultiStaff  result= multiStaffService.selectUserInfo(openId);//查询该员工是否存员工信息
            if (result !=null) {
                List parentList=new ArrayList();
                String jobNo=result.getJobNo();
                List<MultiRecharge> retList=multiRechargeService.selectCList(jobNo,openId,month);
                List<MultiConsume> ret=multiConsumeService.selectXList(jobNo,openId,month);
                if(ret!=null){
                    parentList.add(ret);
                }
                if(retList!=null){
                    parentList.add(retList);

                }
                return new ResponseInfo(InfoEnum.SUCCESS, parentList);
            }
            return new ResponseInfo(InfoEnum.NO_OPENID, -1);
        }

        return new ResponseInfo(InfoEnum.NET_ERROR, -1);

    }

}