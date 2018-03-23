package com.example.backend.Core;

public class Student {
    public Integer id;
    public String f_name;
    public String l_name;
    public String username;
    public String p_word;
    public String email;
    public Student() {}
    public Student(Integer id, String f_name, String l_name, String username, String p_word, String email) {
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.username = username;
        this.p_word = p_word;
        this.email = email;
    }
}
