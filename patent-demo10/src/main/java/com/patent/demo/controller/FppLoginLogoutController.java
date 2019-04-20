package com.patent.demo.controller;


import com.patent.demo.service.FppLoginLogoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wwj
 * @since 2019-04-19
 */
@Controller
@RequestMapping("/fppLoginLogout")
public class FppLoginLogoutController {
    @Autowired
    private FppLoginLogoutService fppLoginLogoutService;

    @RequestMapping("/login")
    @ResponseBody
    public boolean login(@RequestParam String userId, @RequestParam String userName,@RequestParam int userType) {
      return fppLoginLogoutService.login(userId,userName,userType);
    }

    @RequestMapping("/logout")
    @ResponseBody
    public boolean logout(@RequestParam String userId, @RequestParam String userName,@RequestParam int userType) {
        return fppLoginLogoutService.logout(userId,userName,userType);
    }
}

