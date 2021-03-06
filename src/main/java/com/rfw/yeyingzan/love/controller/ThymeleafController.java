package com.rfw.yeyingzan.love.controller;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping
public class ThymeleafController {

    @GetMapping("/")
    public ModelAndView index() {
        final ModelAndView view = new ModelAndView();
        // 设置跳转的视图 默认映射到 src/main/resources/templates/{viewName}.html
        view.setViewName("index");

        // 2020-05-20
        long beginDay = 1589904000000L;

        int days = (int) ((System.currentTimeMillis() - beginDay) / (1000 * 3600 * 24));

        List<String> list = Lists.newArrayList("你的过去", "我来不及参与", "你的未来", "我为你遮风挡雨");

        String name = "大宝 & 二宝";

        view.addObject("days", days);
        view.addObject("list", list);
        view.addObject("name", name);
        return view;
    }
}
