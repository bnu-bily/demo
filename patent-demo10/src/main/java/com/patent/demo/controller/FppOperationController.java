package com.patent.demo.controller;


import com.patent.demo.service.FppOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wwj
 * @since 2019-04-19
 */
@Controller
@RequestMapping("/fppOperation")
public class FppOperationController {

    @Autowired
    private FppOperationService fppOperationService;

    /**
     * 用户操作
     */

    @RequestMapping("/registerUser")
    @ResponseBody
    public void registerUser(@RequestParam String userId, @RequestParam String userName) {
        fppOperationService.registerUser(userId, userName);
    }

    @RequestMapping("/registerPatent")
    @ResponseBody
    public void registerPatent(@RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName, @RequestParam String payment) {
        fppOperationService.registerPatent(userId, userName, patentType, patentId, patentName, payment);
    }

    @RequestMapping("/recorrectPatent")
    @ResponseBody
    public void recorrectPatent(@RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName, @RequestParam String annex) {
        fppOperationService.recorrectPatent(userId, userName, patentType, patentId, patentName, annex);
    }

    @RequestMapping("/requestSubstantiveReview")
    @ResponseBody
    public void requestSubstantiveReview(@RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName, @RequestParam String annex) {
        fppOperationService.requestSubstantiveReview(userId, userName, patentType, patentId, patentName, annex);
    }

    @RequestMapping("/transferPatent")
    @ResponseBody
    public void transferPatent(@RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName, @RequestParam String transferUserId, @RequestParam String transferUserName, @RequestParam String annex) {
        fppOperationService.transferPatent(userId, userName, patentType, patentId, patentName, transferUserId, transferUserName, annex);
    }

    @RequestMapping("/cancelPatent")
    @ResponseBody
    public void cancelPatent(@RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName, @RequestParam String annex) {
        fppOperationService.cancelPatent(userId, userName, patentType, patentId, patentName, annex);
    }

    @RequestMapping("/selectByState")
    @ResponseBody
    public boolean selectByState(@RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName) {
        return fppOperationService.selectByState(userId, userName, patentType, patentId, patentName);
    }

    @RequestMapping("/restorePatent")
    @ResponseBody
    public void restorePatent(@RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName, @RequestParam String annex) {
        fppOperationService.restorePatent(userId, userName, patentType, patentId, patentName, annex);
    }

    @RequestMapping("/recorrectMistake")
    @ResponseBody
    public void recorrectMistake(@RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName, @RequestParam String annex) {
        fppOperationService.recorrectMistake(userId, userName, patentType, patentId, patentName, annex);
    }




    /**
     * 管理员操作
     */

    @RequestMapping("/reviewUser")
    @ResponseBody
    public void reviewUser(@RequestParam String adminId, @RequestParam String adminName, @RequestParam String userId, @RequestParam String userName, @RequestParam int state) {
        fppOperationService.reviewUser(adminId, adminName, userId, userName, state);
    }

    @RequestMapping("/reviewPatent")
    @ResponseBody
    public void reviewPatent(@RequestParam String adminId, @RequestParam String adminName, @RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName, @RequestParam int state) {
        fppOperationService.reviewPatent(adminId, adminName, userId, userName, patentType, patentId, patentName, state);
    }

    @RequestMapping("/preSubstantiveReviewPatent")
    @ResponseBody
    public void preSubstantiveReviewPatent(@RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName) {
        fppOperationService.preSubstantiveReviewPatent(userId, userName, patentType, patentId, patentName);
    }

    @RequestMapping("/preRecorrectPatent")
    @ResponseBody
    public void preRecorrectPatent(@RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName) {
        fppOperationService.preRecorrectPatent(userId, userName, patentType, patentId, patentName);
    }

    @RequestMapping("/reviewRecorrectPatent")
    @ResponseBody
    public void reviewRecorrectPatent(@RequestParam String adminId, @RequestParam String adminName, @RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName, @RequestParam int state) {
        fppOperationService.reviewRecorrectPatent(adminId, adminName, userId, userName, patentType, patentId, patentName, state);
    }

    @RequestMapping("/substantiveReviewPatent")
    @ResponseBody
    public void substantiveReviewPatent(@RequestParam String adminId, @RequestParam String adminName, @RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName, @RequestParam int state) {
        fppOperationService.substantiveReviewPatent(adminId, adminName, userId, userName, patentType, patentId, patentName, state);
    }

    @RequestMapping("/blackUser")
    @ResponseBody
    public void blackUser(@RequestParam String adminId, @RequestParam String adminName, @RequestParam String userId, @RequestParam String userName) {
        fppOperationService.blackUser(adminId, adminName, userId, userName);
    }

    @RequestMapping("/UnBlackUser")
    @ResponseBody
    public void UnBlackUser(@RequestParam String adminId, @RequestParam String adminName, @RequestParam String userId, @RequestParam String userName) {
        fppOperationService.UnBlackUser(adminId, adminName, userId, userName);
    }

    @RequestMapping("/reviewTransferPatent")
    @ResponseBody
    public void reviewTransferPatent(@RequestParam String adminId, @RequestParam String adminName, @RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName, @RequestParam String transferUserId, @RequestParam String transferUserName, @RequestParam int state) {
        fppOperationService.reviewTransferPatent(adminId, adminName, userId, userName, patentType, patentId, patentName, transferUserId, transferUserName, state);
    }

    @RequestMapping("/renewalFeePatent")
    @ResponseBody
    public void renewalFeePatent(@RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName) {
        fppOperationService.renewalFeePatent(userId, userName, patentType, patentId, patentName);
    }

    @RequestMapping("/expirationPatent")
    @ResponseBody
    public void expirationPatent(@RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName) {
        fppOperationService.expirationPatent(userId, userName, patentType, patentId, patentName);
    }

    @RequestMapping("/renewalFeePatentPayment")
    @ResponseBody
    public void renewalFeePatentPayment(@RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName, @RequestParam String payment) {
        fppOperationService.renewalFeePatentPayment(userId, userName, patentType, patentId, patentName, payment);
    }

    @RequestMapping("/reviewPayPatent")
    @ResponseBody
    public void reviewPayPatent(@RequestParam String adminId, @RequestParam String adminName, @RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName, @RequestParam int state) {
        fppOperationService.reviewPayPatent(adminId, adminName, userId, userName, patentType, patentId, patentName, state);
    }

    @RequestMapping("/reviewCancelPatent")
    @ResponseBody
    public void reviewCancelPatent(@RequestParam String adminId, @RequestParam String adminName, @RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName, @RequestParam int state) {
        fppOperationService.reviewCancelPatent(adminId, adminName, userId, userName, patentType, patentId, patentName, state);
    }

    @RequestMapping("/reviewRestorePatent")
    @ResponseBody
    public void reviewRestorePatent(@RequestParam String adminId, @RequestParam String adminName, @RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName, @RequestParam int state) {
        fppOperationService.reviewRestorePatent(adminId, adminName, userId, userName, patentType, patentId, patentName, state);
    }

    @RequestMapping("/reviewRecorrectMistake")
    @ResponseBody
    public void reviewRecorrectMistake(@RequestParam String adminId, @RequestParam String adminName, @RequestParam String userId, @RequestParam String userName, @RequestParam int patentType, @RequestParam String patentId, @RequestParam String patentName, @RequestParam int state) {
        fppOperationService.reviewRecorrectMistake(adminId, adminName, userId, userName, patentType, patentId, patentName, state);
    }

}

