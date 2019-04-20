package com.patent.demo.controller;


import com.patent.demo.entity.FppAdmin;
import com.patent.demo.service.FppAdminService;
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
@RequestMapping("/fppAdmin")
public class FppAdminController {

    @Autowired
    private FppAdminService fppAdminService;

    @RequestMapping("/register")
    @ResponseBody
    public void register(@RequestParam String adminId, @RequestParam String adminPassword,
                         @RequestParam String registrationCode, @RequestParam String adminName, @RequestParam String adminRegion,
                         @RequestParam String adminIdNumber, @RequestParam String adminAddress, @RequestParam String adminTel, @RequestParam String adminEmail, @RequestParam String adminPostalCode) {
        fppAdminService.register(adminId, adminPassword, registrationCode, adminName, adminRegion, adminIdNumber, adminAddress, adminTel, adminEmail, adminPostalCode);
    }

    @RequestMapping("/login")
    @ResponseBody
    public FppAdmin login(@RequestParam String userId, @RequestParam String userPassword) {
        return fppAdminService.login(userId, userPassword);
    }

    @RequestMapping("/isAdmin")
    @ResponseBody
    public boolean isAdmin(@RequestParam String adminId) {
        return fppAdminService.isAdmin(adminId);
    }

    @RequestMapping("/changeAdminPassword")
    @ResponseBody
    public boolean changeAdminPassword(@RequestParam String adminId,@RequestParam String adminName,@RequestParam String oldPassword, @RequestParam String newPassword) {
       return  fppAdminService.changePassword(adminId, adminName, oldPassword, newPassword);
    }
}

