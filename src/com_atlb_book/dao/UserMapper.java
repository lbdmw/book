package com_atlb_book.dao;

import com_atlb_book.pojo.User;

public interface UserMapper {


    /**
     *
     * @param user 根据用户名查询用户信息
     * @return 如果返回null，则用户名或密码错误
     */
    User queryByUserName(User user);
/*    public User queryByUserName(String username);*/

    /**
     *
     * @param user
     * @return -1说明操作失败，其他是sql受影响的行数
     */
    int saveUser(User user);



    /**
     *
     * @param user 根据用户名和密码查询用户信息
     * @return 如果返回null，则用户名或密码错误
     */
    User queryByUserNameAndPassword(User user);

/*    public User queryByUserNameAndPassword(String username,String password);*/

    int updateListLoginTime();
}
