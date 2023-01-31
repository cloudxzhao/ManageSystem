package com.huawei.managersystem.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.handler.Handler;

/**
 * @className: LoginInterceptor
 * @author: Jaara
 * @date: 2023/1/30
 * description：
 **/
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * <p>TODO</p>
     *登录检查
     * 1、 配置拦截器要拦截哪些请求。
     * 2、
     * @param request  TODO
     * @param response TODO
     * @param handler  TODO
     * @return {@link boolean} TODO
     * @author Jaara
     * @date 2023/1/30 22:43
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        登录检查的逻辑。
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if (loginUser != null) return true;
//        response.sendRedirect("/login");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
