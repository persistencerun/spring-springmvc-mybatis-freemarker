package com.sedion.zhe.interceptor;

import org.aspectj.lang.annotation.Aspect;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Mr.W on 16/6/21.
 */

@Aspect
public class JudgeOnlineInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.err.println("JudgeOnlineInterceptor.preHandle");
        //request.getSession().setAttribute("userId", null);
        if (null != request.getSession().getAttribute("userId")) {
            return true;
        } else {
            response.sendRedirect("/");
            return false;
        }
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
