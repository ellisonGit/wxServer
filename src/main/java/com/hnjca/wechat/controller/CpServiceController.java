package com.hnjca.wechat.controller;

import com.github.pagehelper.PageInfo;
import com.hnjca.wechat.enums.InfoEnum;
import com.hnjca.wechat.pojo.*;
import com.hnjca.wechat.service.*;
import com.hnjca.wechat.util.DateUtil;
import com.hnjca.wechat.vo.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Description:
 * User: Ellison
 * Date: 2019-05-11
 * Time: 9:11
 * Modified:
 */
@RestController
@RequestMapping(value = "/cp",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
public class CpServiceController {
    @Autowired
    private MultiStaffService multiStaffService;

    @Autowired
    private WxcpMultiStaffService wxcpMultiStaffService;

    @Autowired
    private MultiConsumeService multiConsumeService;

    @Autowired
    private MultiRechargeService multiRechargeService;

    @Autowired
    private WxMultiRechargeService wxMultiRechargeService;

    @Autowired
    private WxCpTokenService wxCpTokenService;
    /**
     * 员工绑定微信企业号
     *
     * @param openid//就是userid
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
         WxcpMultiStaff  multiStaff= new WxcpMultiStaff();
        multiStaff.setJobNo(stuno);
        multiStaff.setSName(stuname);
        multiStaff.setOpenId(openid);
        int user = wxcpMultiStaffService.selectUser(multiStaff);//查询该员工是否存员工信息
        if (user > 0) {
            int result = wxcpMultiStaffService.selectOpenid(multiStaff);//查询该员工是否存在openid
            if (result > 0) {
                return new ResponseInfo(InfoEnum.OPENID_SUCCESS, result);
            } else {
                int open = wxcpMultiStaffService.updateOpenid( multiStaff);//绑定openid
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
        String  result= wxcpMultiStaffService.findOpenId(openId);//查询该员工是否存员工信息
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
        WxcpMultiStaff multiStaff = wxcpMultiStaffService.selectUserInfo(openId);
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
     *//*
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

    }*/

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


    /**
     * 微信充值记录保存
     * @param wxMultiRecharge
     * @return
     */
  /*  @GetMapping(value = "/saveWxInfo")
    public ResponseInfo saveWx(WxMultiRecharge wxMultiRecharge) throws ParseException {
        String  openId=wxMultiRecharge.getOpenId();
        if (openId == null || "".equals(openId)) {
            return new ResponseInfo(InfoEnum.NO_OPENID, -1);
        }
            MultiStaff  result= multiStaffService.selectUserInfo(openId);//查询该员工是否存员工信息
            if (result !=null) {
                String body=wxMultiRecharge.getBody();
                String eCode=result.getECode();//企业编号
                String jobNo=result.getJobNo();//工号
                String uid=wxMultiRecharge.getUid();//交易单号
                WxMultiRecharge wx =new WxMultiRecharge();
                wx.setUid(wxMultiRecharge.getUid());
                wx.setOpenId(wxMultiRecharge.getOpenId());
                wx.setOutTradeNo(wxMultiRecharge.getOutTradeNo());
                wx.setMoney(wxMultiRecharge.getMoney());
                wx.setState("0");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
                Date date = sdf.parse(body);
                wx.setCreateTime(date);
                wx.setECode(eCode);
                wx.setJobNo(jobNo);
                WxMultiRecharge  isCZ=wxMultiRechargeService.selectOne(openId,eCode,uid);
                if(isCZ==null){
                    int ret=wxMultiRechargeService.insertWxMultiRecharge(wx);
                    if(ret>0){
                        return new ResponseInfo(InfoEnum.SUCCESS, wx);
                    }
                }
            }

        return new ResponseInfo(InfoEnum.SHUJU, result);
    }



    *//**
     * 查询微信充值记是否已同步到本地数据库
     * @param eCode
     * @return
     *//*
    @GetMapping(value = "/seletIf")
    public ResponseInfo seletIf(String eCode) throws ParseException {

        List<WxMultiRecharge>  result= wxMultiRechargeService.selectIf(eCode);
        if (result.size()>0) {
          *//*  for(WxMultiRecharge str : result){
                WxMultiRecharge wx=new WxMultiRecharge();
                wx.setJobNo(str.getJobNo());
                wx.setECode(eCode);
                wx.setOutTradeNo(str.getOutTradeNo());
                int  res= wxMultiRechargeService.updateState(wx);
                if (res>0) {
                    return new ResponseInfo(InfoEnum.SUCCESS, res);
                }
            }*//*
                    return new ResponseInfo(InfoEnum.SUCCESS, result);
                }
        return new ResponseInfo(InfoEnum.NO_SHUJU, result);
    }

    *//**
     * 更新微信充值记同步数据的状态state:1
     * @param eCode
     * @return
     *//*
    @GetMapping(value = "/updateState")
    public ResponseInfo updateState(String eCode,String jobNo,String outTradeNo) throws ParseException {
        WxMultiRecharge wx=new WxMultiRecharge();
        wx.setJobNo(jobNo);
        wx.setECode(eCode);
        wx.setOutTradeNo(outTradeNo);
      int  result= wxMultiRechargeService.updateState(wx);
        if (result>0) {
            return new ResponseInfo(InfoEnum.SUCCESS, result);
        }
        return new ResponseInfo(InfoEnum.NO_SHUJU, result);
    }



    *//**
     * 查询fenye
     * @param
     * @return
     *//*
    @GetMapping(value = "/seletFy")
    public PageInfo<WxMultiRecharge> seletFy(WxMultiRecharge wxMultiRecharge) throws ParseException {

        return wxMultiRechargeService.selectFy(wxMultiRecharge);

    }

    *//**
     * 查询token
     * @param
     * @return
     *//*
    @GetMapping(value = "/selectToken")
    public ResponseInfo selectToken(String id){

        WxCpToken result=wxCpTokenService.selectOne();
        return new ResponseInfo(InfoEnum.SUCCESS,result);
    }

    *//**
     * 更新token
     * @param
     * @return
     *//*
    @GetMapping(value = "/updateToken")
    public int updateToken(String accessToken){
       Date tokenTime=new Date();// new Date()为获取当前系统时间
        return wxCpTokenService.updateToken(accessToken,tokenTime);

    }
*/

}
