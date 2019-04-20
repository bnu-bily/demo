package com.patent.demo.controller;


import com.patent.demo.entity.FppDesignPatent;
import com.patent.demo.entity.FppUser;
import com.patent.demo.service.FppDesignPatentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wwj
 * @since 2019-04-19
 */
@Controller
@RequestMapping("/fppDesignPatent")
public class FppDesignPatentController {
    @Autowired
    private FppDesignPatentService fppDesignPatentService;

//    @RequestMapping("/register")
//    @ResponseBody
//    public void register(@RequestParam String patentId, @RequestParam String patentName, @RequestParam String inventor, @RequestParam String userId, @RequestParam String userName) {
//        fppDesignPatentService.register(patentId, patentName, inventor, userId, userName);
//    }

    @RequestMapping("/register")
    @ResponseBody
    public void register(@RequestParam String applicationNumber, @RequestParam String feeReductionApproval,
                         @RequestParam String applyForApproval, @RequestParam String registeredNumber, @RequestParam String inventionName,
                         @RequestParam String designer, @RequestParam String designer1Region, @RequestParam String designer1IdNumber,
                         @RequestParam String applicant1Id, @RequestParam String applicant1Name, @RequestParam String applicant2Id,
                         @RequestParam String applicant2Name, @RequestParam String applicant3Id, @RequestParam String applicant3Name,
                         @RequestParam String contactName, @RequestParam String contactTel, @RequestParam String contactEmail,
                         @RequestParam String contactPostalCode, @RequestParam String contactAddress, @RequestParam String repersentativeId,
                         @RequestParam String repersentativeName, @RequestParam String agencyName, @RequestParam String agencyCode,
                         @RequestParam String agent1Name, @RequestParam String agent1LicenseNumber, @RequestParam String agent1Tel,
                         @RequestParam String agent2Name, @RequestParam String agent2LicenseNumber, @RequestParam String agent2Tel,
                         @RequestParam String divisionApplicationNumber, @RequestParam String daOriginalNumber,
                         @RequestParam String requestForeignPriorityClaimOriginalInstitutionName, @RequestParam String rfpcPriorApplicationNumber,
                         @RequestParam int withoutLoseNoveltyGracePeriodStatement, @RequestParam int similarDesign, @RequestParam int completeProduct,
                         @RequestParam String listApplicationDocuments, @RequestParam String attachedFileList, @RequestParam String claim,
                         @RequestParam String specification, @RequestParam String specificationAbstract, @RequestParam String annex) {
        fppDesignPatentService.register(applicationNumber, feeReductionApproval, applyForApproval,
                registeredNumber, inventionName, designer, designer1Region, designer1IdNumber, applicant1Id, applicant1Name, applicant2Id,
                applicant2Name, applicant3Id, applicant3Name, contactName, contactTel, contactEmail, contactPostalCode, contactAddress, repersentativeId,
                repersentativeName, agencyName, agencyCode, agent1Name, agent1LicenseNumber, agent1Tel, agent2Name, agent2LicenseNumber, agent2Tel, divisionApplicationNumber,
                daOriginalNumber, requestForeignPriorityClaimOriginalInstitutionName, rfpcPriorApplicationNumber, withoutLoseNoveltyGracePeriodStatement, similarDesign, completeProduct,
                listApplicationDocuments, attachedFileList, claim, specification, specificationAbstract, annex);
    }

    @RequestMapping("/reviewPatent")
    @ResponseBody
    public void reviewPatent(@RequestParam String userId, @RequestParam String userName, @RequestParam String patentId, @RequestParam String patentName) {
        fppDesignPatentService.reviewPatent(userId, userName, patentId, patentName);
    }

    @RequestMapping("/changePatentState")
    @ResponseBody
    public void changePatentState(@RequestParam String userId, @RequestParam String userName, @RequestParam String patentId, @RequestParam String patentName, @RequestParam int state) {
        fppDesignPatentService.changePatentState(userId, userName, patentId, patentName, state);
    }

    @RequestMapping("/selectByState")
    @ResponseBody
    public boolean selectByState(@RequestParam String patentId, @RequestParam String patentName, @RequestParam String userId, @RequestParam String userName) {
        return fppDesignPatentService.selectByState(patentId, patentName, userId, userName);
    }

    @RequestMapping("/transferPatent")
    @ResponseBody
    public boolean transferPatent(@RequestParam String userId, @RequestParam String userName, @RequestParam String patentId, @RequestParam String patentName, @RequestParam String transferUserId, @RequestParam String transferUserName) {
        return fppDesignPatentService.transferPatent(userId, userName, patentId, patentName, transferUserId, transferUserName);
    }

    @RequestMapping("/isRenewalFeePatent")
    @ResponseBody
    public List<Map<String, String>> isRenewalFeePatent(@RequestParam String userId, @RequestParam String userName) {
        return fppDesignPatentService.isRenewalFeePatent(userId, userName);
    }

    @RequestMapping("/reviewPayPatent")
    @ResponseBody
    public void reviewPayPatent(@RequestParam String userId, @RequestParam String userName, @RequestParam String patentId, @RequestParam String patentName, @RequestParam int state) {
        fppDesignPatentService.reviewPayPatent(userId, userName, patentId, patentName, state);
    }

    @RequestMapping("/RecorrectPatent")
    @ResponseBody
    public void RecorrectPatent(@RequestParam String userId, @RequestParam String userName, @RequestParam String patentId, @RequestParam String patentName, @RequestParam int state) {
        fppDesignPatentService.RecorrectPatent(userId, userName, patentId, patentName, state);
    }

    @RequestMapping("/selectByPatentState")
    @ResponseBody
    public void selectByPatentState(@RequestParam String userId, @RequestParam String userName, @RequestParam String patentId, @RequestParam String patentName, @RequestParam int state) {
        fppDesignPatentService.selectByPatentState(userId, userName, patentId, patentName, state);
    }

    @RequestMapping("/selectUserByPatent")
    @ResponseBody
    public String selectUserByPatent(@RequestParam String param) {
        return fppDesignPatentService.selectUserByPatent(param);
    }

    @RequestMapping("/selectPatentByUser")
    @ResponseBody
    public List<FppDesignPatent> selectPatentByUser(@RequestParam String param) {
        return fppDesignPatentService.selectPatentByUser(param);
    }

}

