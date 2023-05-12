package com.example.demo.Controller;

import com.example.demo.Dao.LoginProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.erupt.jpa.dao.EruptDao;
import xyz.erupt.upms.model.EruptUser;
import xyz.erupt.upms.service.EruptUserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;



@Service //使用此注解实现依赖注入相关功能（可选）
public class TestLoginProxy implements LoginProxy {

    @Resource
    private EruptDao eruptDao;

    @Autowired
    private EruptUserService eruptUserService;
    
    // 额外请求参数可从 request 对象中获取
    @Resource
    private HttpServletRequest request;

    @Override
    public EruptUser login(String account, String pwd) {
        // 调用默认登录方法
        // eruptUserService.login(account, pwd);        
        // 错误提示
        // throw new RuntimeException("账号或密码错误"); 
        return eruptDao.queryEntity(EruptUser.class, "account = 'bi'"); //获取用户对象
    }

    @Override
    public void loginSuccess(EruptUser eruptUser, String token) {
        // TODO
    }

    @Override
    public void logout(String token) {
        // TODO
    }

    @Override
    public void beforeChangePwd(EruptUser eruptUser, String newPwd) {
        // TODO
    }
    
}
