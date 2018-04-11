package com.example.backend.Core;

public class StudentUrlLinks {
    public Integer id;
    public Integer student_id;
    public String programming_langs;
    public String academics;
    public String interests;

    public StudentUrlLinks() {}
    public StudentUrlLinks(Integer id, Integer student_id, String programming_langs, String academics, String interests) {
        this.id = id;
        this.student_id = student_id;
        this.programming_langs = programming_langs;
        this.academics = academics;
        this.interests = interests;
    }
}
