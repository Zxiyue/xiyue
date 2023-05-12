package com.example.demo.Controller;

import com.example.demo.Dao.SimpleDao;
//import com.example.demo.Enity.Simple;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/simple")
@Api(tags = "聊天模块")
public class SimpleController {
    @Autowired
    private SimpleDao simpleDao;

    @PostMapping
    public String add(){
        return "成功";
    }

    @DeleteMapping
    public String delete(){
        return "删除成功";
    }

    @GetMapping
    private Object list(){
        return simpleDao.findAll();
    }

}
