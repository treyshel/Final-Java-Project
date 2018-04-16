package com.example.backend.Core;

public class Recruiter {
    public Integer id;
    public String f_name;
    public String l_name;
    public String title;
    public String session_key;
    public String username;
    public String p_word;
    public String email;
    public String position_level;
    public String company_name;
    public String company_location;
    public String langs_used;
    public String website_url;

    Recruiter() {}

    public Recruiter(Integer id, String f_name, String l_name, String title, String session_key, String username, String p_word, String email, String position_level, String company_name, String company_location, String langs_used, String website_url) {
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.title = title;
        this.session_key = session_key;
        this.username = username;
        this.p_word = p_word;
        this.email = email;
        this.position_level = position_level;
        this.company_name = company_name;
        this.company_location = company_location;
        this.langs_used = langs_used;
        this.website_url = website_url;
    }
}
