package com_atlb_book.test;

import com_atlb_book.pojo.User;
import com_atlb_book.service.UserService;
import com_atlb_book.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {
    UserService service=new UserServiceImpl();

    @Test
    public void registUser() {
        service.registUser(new User(null,"bbj168","666666","bbj168@qq.com"));
        service.registUser(new User(null,"jjz168","156456","jjz168@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(service.login(new User("admin","admin")));
    }

/*    @Test
    public void existsUsername() {
        if (service.existsUsername(new User("admin"))){
            System.out.println("用户名已存在");
        }else {
            System.out.println("用户名可用");
        }
    }*/
}