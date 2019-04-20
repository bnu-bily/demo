package com.patent.demo.controller;


import com.patent.demo.entity.FppAccountKeyCenter;
import com.patent.demo.service.FppAccountKeyCenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wwj
 * @since 2019-04-19
 */
@Controller
@RequestMapping("/fppAccountKeyCenter")
public class FppAccountKeyCenterController {

    @Autowired
    private FppAccountKeyCenterService fppAccountKeyCenterService;

}

