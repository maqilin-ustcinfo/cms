package com.tz.cms.sysmgr.controller;

import com.tz.cms.framework.util.UserUtils;
import com.tz.cms.sysmgr.entity.Menu;
import com.tz.cms.sysmgr.entity.User;
import com.tz.cms.sysmgr.service.IMenuService;
import com.tz.cms.sysmgr.service.impl.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author maqilin
 * @description: 登陆的控制层
 * @date 2019/1/30 14:37
 */
@Controller
public class LoginController {

    private static Logger logger = Logger.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private IMenuService menuService;

    /**
     * 跳转到登陆页面
     * @return
     */
    @RequestMapping("/gotoLogin")
    public String gotoLogin(){
        return "login";
    }

    /**
     * 登陆
     * @return
     */
    @RequestMapping("/login")
    public String login(String loginName, String password, Model model, HttpSession session){
        logger.info("登陆名："+loginName);
        if(StringUtils.isNoneEmpty(loginName)
                && StringUtils.isNoneEmpty(password)){
            User user = userService.loginUser(loginName,password);
            if(user != null){
                // 登陆用户信息存入session
                session.setAttribute("user",user);
                return "redirect:/main";
            }else{
                model.addAttribute("loginFlag","用户名或者密码错误");
                return "forward:/WEB-INF/pages/login.jsp";
            }
        }else{
            model.addAttribute("loginFlag","用户名或者密码为空");
            return "forward:/WEB-INF/pages/login.jsp";
        }
    }

    /**
     * 登出
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login";
    }

    /**
     * 转到主页面
     * @return
     */
    @RequestMapping("/main")
    public String main(Model model){
        // 根据用户ID查询当前登陆用户有那些菜单
        List<Menu> menuList =
                menuService.getMenuListByUserId(Long.parseLong(UserUtils.getCurrrentUserId()+""));
        model.addAttribute("menuList",menuList);
        return "main/main";
    }
}
