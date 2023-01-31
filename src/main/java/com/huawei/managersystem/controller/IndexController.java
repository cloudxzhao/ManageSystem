package com.huawei.managersystem.controller;

import com.huawei.managersystem.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

/**
 * @className: IndexController
 * @author: Jaara
 * @date: 2023/1/30
 * description：
 **/
@Controller
public class IndexController {
//    去登录页

    /**
     * <p>前往登录页</p>
     *
     * @return {@link String} TODO
     * @author Jaara
     * @date 2023/1/30 20:30
     */
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {
        return "login";
    }

    /**
     * <p>TODO</p>
     * 重定向到 /main.html，登录之后再刷新，
     * 就是刷新的/main.html，
     *
     * @param user TODO
     * @return {@link String} TODO
     * @author Jaara
     * @date 2023/1/30 21:06
     * <p>
     * 重定向相当于是在地址栏输一遍重定向的地址。
     * 直接 return 相当于是转发，将页面转发到这个页面，地址栏的地址是不会变化的。
     * 这样就解决了表达重复提交的问题。
     */
    @PostMapping(value = {"/login"})
    public String main(User user, Model model, HttpSession session) {
        System.out.println(user);
        if (user.getUsername().equals("赵晓杰") && user.getPassword().equals("123456")) {
            session.setAttribute("loginUser", user);
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "账号密码错误");
            return "login";
        }
    }

    /**
     * <p>TODO</p>
     * 这个main.html不能直接暴露，
     * 必须做一个判断：
     * 只有登录成功了之后才能进入这个页面。
     * 现在为了简单，就使用判断，以后就是使用拦截器，过滤器等等机制来进行判断。
     *
     * @return {@link String} TODO
     * @author Jaara
     * @date 2023/1/30 21:10
     */
    @GetMapping(value = {"/main.html"})
    public String mainPage(HttpSession session, Model model) {
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) {
            return "main";
        } else {
            model.addAttribute("msg", "先重新登录");
            return "login";
        }

    }
}
