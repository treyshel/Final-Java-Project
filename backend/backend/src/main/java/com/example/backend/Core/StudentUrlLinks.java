package com.example.backend.Core;

public class StudentUrlLinks {
    public Integer id;
    public Integer student_id;
    public String linkedin_url;
    public String resume_url;
    public String github_url;
    public String portfolio_url;

    public StudentUrlLinks(Integer id, Integer student_id, String linkedin_url, String resume_url, String github_url, String portfolio_url) {
        this.id = id;
        this.student_id = student_id;
        this.linkedin_url = linkedin_url;
        this.resume_url = resume_url;
        this.github_url = github_url;
        this.portfolio_url = portfolio_url;

    }
}
