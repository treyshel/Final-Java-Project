package com.example.backend.Core;

public class Student {
    public Integer id;
    public String f_name;
    public String l_name;
    public String session_key;
    public String username;
    public String p_word;
    public String email;
    public String programming_langs;
    public String desired_location;
    public String position_level;
    public String resume_url;
    public String github_url;
    public String portfolio_url;

    public Student() {}
    public Student(Integer id, String f_name, String l_name, String session_key,String username, String p_word, String email, String programming_langs, String desired_location, String position_level, String resume_url, String github_url, String portfolio_url) {
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.session_key = session_key;
        this.username = username;
        this.p_word = p_word;
        this.email = email;
        this.programming_langs = programming_langs;
        this.desired_location = desired_location;
        this.position_level = position_level;
        this.resume_url = resume_url;
        this.github_url = github_url;
        this.portfolio_url = portfolio_url;
    }
}
