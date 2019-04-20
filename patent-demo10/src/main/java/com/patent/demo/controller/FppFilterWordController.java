package com.patent.demo.controller;


import com.patent.demo.entity.FppFilterWord;
import com.patent.demo.mapper.FppFilterWordMapper;
import com.patent.demo.service.FppFilterWordService;
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
@RequestMapping("/fppFilterWord")
public class FppFilterWordController {

    @Autowired
    private FppFilterWordService fppFilterWordService;

    @RequestMapping("/addKeyword")
    @ResponseBody
    public Boolean addKeyword(@RequestParam String keyWord) {
        return fppFilterWordService.insert(new FppFilterWord(keyWord));
    }

    @RequestMapping("/isEffectKeyword")
    @ResponseBody
    public boolean isEffectKeyword(@RequestParam String keyWord, @RequestParam int state) {
        return fppFilterWordService.isEffectKeyword(keyWord, state);
    }

    @RequestMapping("/containKeyWord")
    @ResponseBody
    public boolean containKeyWord(@RequestParam String patentName) {
        return fppFilterWordService.containKeyWord(patentName);
    }

}

