package com_atlb_book.service;

import com_atlb_book.pojo.User;

public interface UserService {

    /**
     * 注册
     * @param user
     */
    public int registUser(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    public  User  login(User user);

    /**
     * 检查用户名是否可用
     * @param user
     * @return
     */
    public  User existsUsername(User user);

}
