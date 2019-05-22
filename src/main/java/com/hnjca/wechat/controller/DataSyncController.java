package com.hnjca.wechat.controller;

import com.hnjca.wechat.enums.InfoEnum;
import com.hnjca.wechat.pojo.*;
import com.hnjca.wechat.service.*;
import com.hnjca.wechat.util.DateUtil;
import com.hnjca.wechat.util.Utils;
import com.hnjca.wechat.vo.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Description: 数据同步
 * User: YangYong
 * Date: 2019-04-26
 * Time: 17:47
 * Modified:
 */
@RestController
@RequestMapping(value = "/sync",produces = "application/json;charset=utf-8")
public class DataSyncController {

    @Autowired
    private MultiTerminalService multiTerminalService;

    @Autowired
    private MultiStaffService multiStaffService;

    @Autowired
    private MultiDepartsService multiDepartsService;

    @Autowired
    private MultiConsumeService multiConsumeService;

    @Autowired
    private MultiRechargeService multiRechargeService;

    /**
     * 获取员工的总数
     * @param eCode
     * @return
     */
    @GetMapping(value = "/getStaffCount")
    public ResponseInfo getStaffCount(String eCode){

        if(eCode == null || eCode.equals("")){
            return new ResponseInfo(InfoEnum.NO_ECODE,-1);
        }

        int result = this.multiStaffService.countByEcode(eCode);
        return new ResponseInfo(InfoEnum.SUCCESS,result);
    }

    /**
     * 获取部门的总数
     * @param eCode
     * @return
     */
    @GetMapping(value = "/getDepartsCount")
    public ResponseInfo getDepartsCount(String eCode){

        if(eCode == null || eCode.equals("")){
            return new ResponseInfo(InfoEnum.NO_ECODE,-1);
        }

        int result = this.multiDepartsService.countByEcode(eCode);
        return new ResponseInfo(InfoEnum.SUCCESS,result);
    }

    /**
     * 获取设备的总数
     * @param eCode
     * @return
     */
    @GetMapping(value = "/getTerminalCount")
    public ResponseInfo getTerminalCount(String eCode){

        if(eCode == null || eCode.equals("")){
            return new ResponseInfo(InfoEnum.NO_ECODE,-1);
        }

        int result = this.multiTerminalService.countByCondition(eCode);
        return new ResponseInfo(InfoEnum.SUCCESS,result);
    }

    /**
     * 通过企业编码移除员工数据
     * @param eCode todo 注释
     * @return
     */
    @GetMapping(value = "/removeStaff")
    public ResponseInfo removeStaff(String eCode){

        if(eCode == null || eCode.equals("")){
            return new ResponseInfo(InfoEnum.NO_ECODE,-1);
        }

        int result = this.multiStaffService.deleteByEcode(eCode);
        return new ResponseInfo(InfoEnum.SUCCESS,result);
    }

    /**
     * 通过企业编码移除设备数据
     * @param eCode
     * @return
     */
    @GetMapping(value = "/removeTerminal")
    public ResponseInfo removeTerminal(String eCode){

        if(eCode == null || eCode.equals("")){
            return new ResponseInfo(InfoEnum.NO_ECODE,-1);
        }

        int result = this.multiTerminalService.deleteByEcode(eCode);
        return new ResponseInfo(InfoEnum.SUCCESS,result);
    }

    /**
     * 通过企业编码移除部门数据
     * @param eCode
     * @return
     */
    @GetMapping(value = "/removeDeparts")
    public ResponseInfo removeDeparts(String eCode){

        if(eCode == null || eCode.equals("")){
            return new ResponseInfo(InfoEnum.NO_ECODE,-1);
        }

        int result = this.multiDepartsService.deleteByEcode(eCode);
        return new ResponseInfo(InfoEnum.SUCCESS,result);
    }


    /**
     * 新增员工信息
     * @param eCode
     * @return
     */
    @PostMapping(value = "/addStaff")
    public ResponseInfo addStaff(String eCode,String sName,String departsId,String jobNo,String cardNo){

        if(eCode == null || eCode.equals("")){
            return new ResponseInfo(InfoEnum.NO_ECODE,-1);
        }

        if(sName == null || sName.equals("")){
            return new ResponseInfo(InfoEnum.NO_SNAME,-1);
        }

        if(departsId == null || departsId.equals("")){
            return new ResponseInfo(InfoEnum.NO_DEPARTSID,-1);
        }

        if(jobNo == null || jobNo.equals("")){
            return new ResponseInfo(InfoEnum.NO_JOBNO,-1);
        }

        if(cardNo == null || cardNo.equals("")){
            return new ResponseInfo(InfoEnum.NO_CARDNO,-1);
        }


        MultiStaff multiStaff = new MultiStaff();
        multiStaff.setSName(sName);
        multiStaff.setDepartsId(departsId);
        multiStaff.setECode(eCode);
        multiStaff.setJobNo(jobNo);
        multiStaff.setCardNo(cardNo);

        int result = this.multiStaffService.insertMultiStaff(multiStaff);

        return new ResponseInfo(InfoEnum.SUCCESS,result);
    }


    /**
     * 新增部门信息
     * @param eCode
     * @return
     */
    @PostMapping(value = "/addDepart")
    public ResponseInfo addDepart(String eCode,String departId,String insideId,String groupId,String departName,
                                    String principal,String empPrefix){
        if(eCode == null || eCode.equals("")){
            return new ResponseInfo(InfoEnum.NO_ECODE,-1);
        }

        MultiDeparts multiDeparts = new MultiDeparts();
        multiDeparts.setDepartId(departId);
        multiDeparts.setECode(eCode);
        multiDeparts.setDepartName(departName);
        multiDeparts.setEmpPrefix(empPrefix);
        multiDeparts.setPrincipal(principal);
        multiDeparts.setInsideId(insideId);
        multiDeparts.setGroupId(groupId);

        int result = this.multiDepartsService.insertMultiDeparts(multiDeparts);

        return new ResponseInfo(InfoEnum.SUCCESS,result);
    }

    /**
     * 新增设备信息
     * @param eCode
     * @return
     */
    @PostMapping(value = "/addTerminal")
    public ResponseInfo addTerminal(String eCode,String tName,String tNo,Integer tType){
        if(eCode == null || eCode.equals("")){
            return new ResponseInfo(InfoEnum.NO_ECODE,-1);
        }

        MultiTerminal multiTerminal = new MultiTerminal();
        multiTerminal.setECode(eCode);
        multiTerminal.setTName(tName);
        multiTerminal.setTNo(tNo);
        multiTerminal.setTType(tType);

        int result = this.multiTerminalService.insertMultiTerminal(multiTerminal);

        return new ResponseInfo(InfoEnum.SUCCESS,result);
    }


    /**
     * 添加消费记录
     * @param eCode
     * @param money
     * @param remainMoney
     * @param consumeType
     * @param createTime
     * @param poseSequ
     * @param cardSequ
     * @param tNo
     * @param jobNo
     * @param cardNo
     * @param req
     * @return
     */
    @PostMapping(value = "addConsume")
    public ResponseInfo addConsume(String eCode, String money , String remainMoney, String consumeType, String createTime,
                                   String poseSequ, String cardSequ, String tNo, String jobNo, String cardNo, HttpServletRequest req){

        if(eCode == null || eCode.equals("")){
            return new ResponseInfo(InfoEnum.NO_ECODE,-1);
        }

        MultiConsume multiConsume = new MultiConsume();
        multiConsume.setCardSequ(cardSequ);
        multiConsume.setConsumeType(consumeType);
        multiConsume.setCreateTime(DateUtil.strToDate(createTime,null));
        multiConsume.setECode(eCode);
        multiConsume.setMoney(money);
        multiConsume.setRemainMoney(remainMoney);
        multiConsume.setPoseSequ(poseSequ);
        multiConsume.setTNo(tNo);
        multiConsume.setCardNo(cardNo);
        multiConsume.setJobNo(jobNo);
        multiConsume.setCreateIp(Utils.getIp(req));

        int result = this.multiConsumeService.insertMultiConsume(multiConsume);

        return new ResponseInfo(InfoEnum.SUCCESS,result);
    }

    /**
     * 添加充值记录
     * @param eCode
     * @return
     */
    @PostMapping(value = "addCharge")
    public ResponseInfo addCharge(String eCode, String empId , String cardId, String chargeMoney, String cardBalance,
                                   String opYmd, String cardTimes, String cardSequ, String Kind, String opUser,
                                  String opDate, String remark, String difineSequ ){
        if(eCode == null || eCode.equals("")){
            return new ResponseInfo(InfoEnum.NO_ECODE,-1);
        }
        MultiRecharge multiRecharge = new MultiRecharge();
        multiRecharge.setECode(eCode);
        multiRecharge.setEmpId(empId);
        multiRecharge.setCardId(cardId);
        multiRecharge.setChargeMoney(chargeMoney);
        multiRecharge.setCardBalance(cardBalance);
        multiRecharge.setOpYmd(DateUtil.strToDate(opYmd,null));
        multiRecharge.setCardTimes(cardTimes);
        multiRecharge.setCardSequ(cardSequ);
        multiRecharge.setKind(Kind);
        multiRecharge.setOpUser(opUser);
        multiRecharge.setOpDate(DateUtil.strToDate(opDate,null));
        multiRecharge.setRemark(remark);
        multiRecharge.setDifineSequ(difineSequ);

        int result = multiRechargeService.insertMultiRecharge(multiRecharge);

        return new ResponseInfo(InfoEnum.SUCCESS,result);
    }
}
