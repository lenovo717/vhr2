package com.zzyy.vhr.controller;

import com.zzyy.vhr.model.RespBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @GetMapping("/login")
    public RespBean login()
    {
       return RespBean.error("未登录，请登陆");
    }
}
