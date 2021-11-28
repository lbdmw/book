package com_atlb_book.service.impl;

import com_atlb_book.mapper.UserMapper;
import com_atlb_book.pojo.User;
import com_atlb_book.service.UserService;
import com_atlb_book.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author 城南
 * @Date 2021/10/31 23:49
 * @Version 1.0
 **/
public class UserServiceImpl implements UserService {

    SqlSession session = MyBatisUtil.getSession();
    UserMapper mapper = session.getMapper(UserMapper.class);


   //注册
    @Override
    public int registUser(User user) {
        int user1 = mapper.saveUser(user);
        session.commit();
      return   user1;
    }

    @Test
    public void testInsert(){
        System.out.println(registUser(new User("xuhao", "xuhao", "xuhao@qq.com")));
    }

    /**@localhost
     * 登录
     * @param user
     * @return 返回null说明没有查到
     * */
    @Override
    public User login(User user) {
        return mapper.queryByUserNameAndPassword(user);
    }


    //检查用户名是否可用
 /*   @Override
    public boolean existsUsername(String username) {
        return userMapper.queryByUserName(username) != null;
    }*/

    @Override
    public User existsUsername(User user) {

        return mapper.queryByUserName(user) ;
    }

    @Test
    public void test(){
        System.out.println(existsUsername(mapper.queryByUserName(new User())));

    }

}
