package com.hwua.springboot04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
public class LoginController {

    @RequestMapping("/doLogin")
    public String doLogin(String username, String password, HttpSession session) throws UnsupportedEncodingException {
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登录成功
            session.setAttribute("username",username);
            return "redirect:/main";
        }else{
            //登录失败
            String msg = URLEncoder.encode("用户名或密码错误","UTF-8");
            return "redirect:/login?msg="+msg;
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:login";
    }

}
