package com.webapp.dao;

//import java.util.List;

public class StudentPO {
    private int userId;
    private String userName;
    private int userAge;
    private String userPwd;
    private String realName;
    private int userPower;
    public int getUserPower(){
        return userPower;
    }
    public void setuserPower(int userpower) {
        this.userPower = userpower;
    }
    public String getRealName(){
        return realName;
    }
    public void setRealName(String realname) {
        this.realName = realname;
    }
    public String getUserPwd() {
        return userPwd;
    }
    public void setUserPwd(String userpwd) {
        this.userPwd = userpwd;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getUserAge() {
        return userAge;
    }
    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }
    
}
