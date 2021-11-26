package com_atlb_book.web;

import com_atlb_book.pojo.User;
import com_atlb_book.service.UserService;
import com_atlb_book.service.impl.UserServiceImpl;
import com_atlb_book.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * @ClassName UserServlet
 * @Description TODO
 * @Author 城南
 * @Date 2021/11/23 18:37
 * @Version 1.0
 **/
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {

    private UserService service=new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("utf-8");
        resp.setContentType("text/html; charset=utf-8");
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");

        if ("login".equals(action)){
            login(req,resp);
        }else if ("regist".equals(action)){
            regist(req,resp);
        }
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理登录的请求
        String username = req.getParameter("username1");
        String password = req.getParameter("password1");
        //调用UserService实现登录
        User loginUser =service.login(new User(username,password));
        if ( loginUser==null){
            //把错误信息和回显得表单信息保存到request中
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            //登陆失败，跳回登录页面
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);

        }else {
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws  ServletException,IOException{
        //处理注册的请求

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //写死验证码为123456；
        if ("123456".equals(code)){
            //检查用户名是否可用

            User user = service.existsUsername(new User(username));

            if (user!=null){
                System.out.println("用户名"+username+"已存在");
                //回显
                //不可用
                req.setAttribute("msg","用户名已存在");
                req.setAttribute("username",username);
                req.setAttribute("email",email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);


            }else {
                //可用，保存到数据库
                Date date = new Date();
                /*SimpleDateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
                format1.format(date);*/
                service.registUser(new User(username, password, email,date));
                SqlSession session = MyBatisUtil.getSession();
                session.commit();
                req.setAttribute("msg","注册成功，请重新登录");
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            }
        }else {
            //错误，跳回注册页面
            System.out.println("验证码"+code+"错误");
            //回显
            req.setAttribute("msg","验证码错误");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }
}
