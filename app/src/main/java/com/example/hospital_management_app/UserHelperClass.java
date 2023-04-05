package com.example.hospital_management_app;

public class UserHelperClass {
    String first,last,email,no,password,options;

    public UserHelperClass(){};

    public void setFirst(String m1){
        first=m1;
    }
    public void  setLast(String m2){
        last=m2;
    }
    public void  setEmail(String m3){
        email=m3;
    }
    public void  setNo(String m4){
        no=m4;
    }
    public void  setPassword(String m5){
        password=m5;
    }
    public void  setOptions(String m6){
        options=m6;
    }

    public String getFirst()
    {
        return first;
    }
    public String getLast()
    {
        return last;
    }
    public String getEmail()
    {
        return email;
    }
    public String getNo()
    {
        return no;
    }
    public String getPassword()
    {
        return password;
    }
    public String getOptions()
    {
        return options;
    }




}
