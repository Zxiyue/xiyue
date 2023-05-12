package com.example.demo.Dao;

import com.example.demo.Dao.LoginProxy;

// 仅需实现 LoginProxy 接口就可以自定义登录规则
public @interface EruptLogin {

    Class<? extends LoginProxy> value();

}
