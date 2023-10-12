package com.wangyu.springbootstudy.interfaces;

import com.alibaba.fastjson.JSON;
import com.mysql.cj.xdevapi.JsonNumber;
import com.wangyu.springbootstudy.domain.data.User;
import com.wangyu.springbootstudy.infrastructure.repository.mysql.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserStorage userStorage;
    @GetMapping("/all")
    public String getAllUsers() {
        List<User> users = userStorage.getAll();
        return JSON.toJSONString(users);
    }

}
