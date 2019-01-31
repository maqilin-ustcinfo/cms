package com.tz.cms.framework.interceptor;

import com.tz.cms.sysmgr.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author maqilin
 * @description: 登陆拦截器
 * @date 2019/1/31 8:51
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception {

        //将不需要登陆验证的URI过滤
        String uri = request.getRequestURI();
        if(uri.indexOf("login") >= 0 || uri.indexOf("gotoLogin") >= 0){
            return true;
        }

        // 检查是否从session获取用户信息
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        // 检查用户信息是否为空
        if(user != null){
            // 已经登陆
            return true;
        }else{
            // 未登陆，转发到首页
            request.getRequestDispatcher("/index.jsp").forward(request,response);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
