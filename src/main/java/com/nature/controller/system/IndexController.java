package com.nature.controller.system;

import com.nature.controller.basic.BaseController;
import com.nature.service.system.AdminService;
import com.nature.util.CommonResult;
import com.nature.component.SigarUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

/**
 * springmvc_mybatis
 * IndexController
 *
 * @Author: 竺志伟
 * @Date: 2018-04-12 14:48
 */
@Controller
public class IndexController extends BaseController
{
    @Autowired
    AdminService adminService;
    @Autowired
    SigarUtils sigarUtils;
    @Autowired
    HttpServletRequest request;

    Logger logger = LoggerFactory.getLogger(IndexController.class);


    /**
     * 进入首页
     * To index string.
     *
     * @return the string
     * @author:竺志伟
     * @date :2018-05-29 17:05:17
     */
    @RequestMapping(value = "/")
    public String toIndex()
    {
        return "index_vm";
    }


    /**
     * 进入 登录页面
     * To login string.
     *
     * @return the string
     * @author:竺志伟
     * @date :2018-05-29 17:05:31
     */
    @RequestMapping(value = "/toLogin")
    public String toLogin()
    {
        return "login_vm";
    }

    /**
     * 登录
     * Login common result.
     *
     * @param loginName the login name
     * @param loginPass the login pass
     * @return the common result
     * @author:竺志伟
     * @date :2018-05-29 17:07:16
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    public CommonResult login(
            @RequestParam(value = "loginName", defaultValue = "", required = true) String loginName,
            @RequestParam(value = "loginPass", defaultValue = "", required = true) String loginPass)
    {

        return resultBoolWrapper(false, "登录成功", "用户名密码错误", null);
    }


    /**
     * 测试mybatis 查询
     * Mybatis common result.
     *
     * @return the common result
     * @author:竺志伟
     * @date :2018-05-29 09:45:47
     */
    @RequestMapping(value = "/mybatis")
    @ResponseBody
    public CommonResult mybatis()
    {
        return resultSuccessWrapper("用户查询成功", adminService.listPage(1, 10, null));
    }
}
