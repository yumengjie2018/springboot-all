package com.jiemeng.service.impl;

import com.jiemeng.mapper.UserMapper;
import com.jiemeng.pojo.User;
import com.jiemeng.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;
    public User queryUserByName(String name){
        ArrayList<User> list = new ArrayList<>();
        list.add(new User(1,"root","123456","user:add"));
        list.add(new User(2,"admin","123456","user:update"));
        list.add(new User(3,"jiemeng","123456","user:add"));

        for (User user : list) {
            if(user.getName().equals(name)){
                return user;
            }
        }
        return new User();
//        return mapper.queryUserByName(name);
    }
}
