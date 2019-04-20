package com.patent.demo.controller;


import com.patent.demo.entity.FppUser;
import com.patent.demo.service.FppUserService;
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
@RequestMapping("/fppUser")
public class FppUserController {
    @Autowired
    private FppUserService fppUserService;

    @RequestMapping("/register")
    @ResponseBody
    public void register(@RequestParam String userId, @RequestParam String userPassword, @RequestParam int registrationRequesterType, @RequestParam String registrationRequesterCode, @RequestParam String patentAgencyCode, @RequestParam String rrName, @RequestParam String rrRegion, @RequestParam String rrAddress, @RequestParam String rrTel, @RequestParam String rrEmail, @RequestParam String rrPostalCode, @RequestParam int rrReceiverInformation, @RequestParam int digitalCertificateForm, @RequestParam String contactName, @RequestParam String contactAddress, @RequestParam String contactTel, @RequestParam String contactEmail, @RequestParam String contactIdNumber, @RequestParam String listOfAccessories, @RequestParam String annex) {
        fppUserService.register(userId, userPassword, registrationRequesterType, registrationRequesterCode, patentAgencyCode, rrName, rrRegion, rrAddress, rrTel, rrEmail, rrPostalCode, rrReceiverInformation, digitalCertificateForm, contactName, contactAddress, contactTel, contactEmail, contactIdNumber, listOfAccessories, annex);
    }

    @RequestMapping("/approvalRegisterUser")
    @ResponseBody
    public void approvalRegisterUser(@RequestParam String userId, @RequestParam String userPassword, @RequestParam String adminId, @RequestParam String adminName) {
        fppUserService.approvalRegisterUser(userId, userPassword, adminId, adminName);
    }

    @RequestMapping("/login")
    @ResponseBody
    public FppUser login(@RequestParam String userId, @RequestParam String userPassword) {
        return fppUserService.login(userId, userPassword);
    }

    @RequestMapping("/blackUser")
    @ResponseBody
    public void blackUser(@RequestParam String userId, @RequestParam String userName) {
        fppUserService.blackUser(userId, userName);
    }

    @RequestMapping("/UnBlackUser")
    @ResponseBody
    public void UnBlackUser(@RequestParam String userId, @RequestParam String userName) {
        fppUserService.UnBlackUser(userId, userName);
    }

    @RequestMapping("/isUser")
    @ResponseBody
    public boolean isUser(@RequestParam String userId, @RequestParam String userName) {
        return fppUserService.isUser(userId, userName);
    }

    //用户查询用户这一部分还有待思考
    @RequestMapping("/selectByParam")
    @ResponseBody
    public FppUser selectByParam(@RequestParam String param) {
        return fppUserService.selectById(param);
    }

    @RequestMapping("/isExistUser")
    @ResponseBody
    public boolean isExistUser(@RequestParam String userId) {
        return fppUserService.isExistUser(userId);
    }

    @RequestMapping("/isUserInState")
    @ResponseBody
    public boolean isUserInState(@RequestParam String userId, @RequestParam String userName, int state) {
        return fppUserService.isUserInState(userId, userName, state);
    }

    @RequestMapping("/selectUserByUser")
    @ResponseBody
    public FppUser selectUserByUser(@RequestParam String param) {
        return fppUserService.selectById(param);
    }

    @RequestMapping("/changeUserPassword")
    @ResponseBody
    public boolean changeUserPassword(@RequestParam String userId, @RequestParam String userName,@RequestParam String oldPassword,@RequestParam String newPassword) {
        return fppUserService.changePassword(userId, userName, oldPassword, newPassword);
    }
}

