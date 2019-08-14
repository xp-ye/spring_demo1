package com.xp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hello")
public class TestContrller {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/say")
    public Object say(String name){
        return  "hello world,"+name;
}

    @RequestMapping("/say1")
    public Object say1(String name){
        return  "hello world,"+name;
    }

    @RequestMapping("/userList")
    public Object userList(){
        List<Map<String,Object>> list =jdbcTemplate.queryForList("select * from t_user");
        return list;
    }

    @RequestMapping("/add")
    public Object add(int id,String name){

//      int a =  jdbcTemplate.update("insert into t_user (id,name) values (?,?)",id,name);
        int a =  jdbcTemplate.update("insert into t_user (id,name) values (?,?)",id,name);
        return "插入成功"+a+"条";
    }

    @RequestMapping("/delete")
    public Object delete(int id){

//        int a =  jdbcTemplate.update("delete from t_user where id = ?",id);
        int a =  jdbcTemplate.update("delete from t_user where id = "+id);

        return "删除成功"+a+"条";
    }

}
