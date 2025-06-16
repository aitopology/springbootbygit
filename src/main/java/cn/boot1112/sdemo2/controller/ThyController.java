package cn.boot1112.sdemo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Controller///告诉SpringBoot这是一个控制器
public class ThyController {
    @RequestMapping("/thy")//映射路径
    public String thy(Model model) {//添加数据
        model.addAttribute("message","今天是一个下午");//添加数据
        model.addAttribute("currentTime",new Date());//添加数据
        return "thy";//返回thy.html
    }
}
