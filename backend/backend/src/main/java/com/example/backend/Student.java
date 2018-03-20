package com.example.backend;

public class Student {
    public Integer id;
    public String f_name;
    public String l_name;
    public String username;
    public String password;
    public String email;

    public Student(Integer id, String f_name, String l_name, String username, String password, String email) {
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
