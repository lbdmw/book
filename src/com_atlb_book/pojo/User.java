package com_atlb_book.pojo;

import java.util.Date;

/**
 * @ClassName User
 * @Description TODO
 * @Author 城南
 * @Date 2021/11/26 13:48
 * @Version 1.0
 **/
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private Date regtime;
    private Date logintime;
    
    
    public User() {
    }
    
    public User(String username) {
        this.username = username;
    }
    
    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    
    public User(String username, String password, String email, Date regtime) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.regtime = regtime;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    
    public User(Integer id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
    
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
}
