package com.news.love.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Administrator on 2017/8/9.
 */
@Controller
public class TestController {

    @RequestMapping(value = "/test")
    public ModelAndView initLoad(){
        System.out.print("ss-------------");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }
}
