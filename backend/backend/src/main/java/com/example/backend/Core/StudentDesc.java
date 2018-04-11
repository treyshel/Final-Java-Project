package com.example.backend.Core;

public class StudentDesc {
    public Integer id;
    public Integer student_id;
    public String programming_langs;
    public String academics;
    public String desired_location;

    public StudentDesc(){}

    public StudentDesc(Integer id, Integer student_id, String programming_langs, String academics, String desired_location) {
        this.id = id;
        this.student_id = student_id;
        this.programming_langs = programming_langs;
        this.academics = academics;
        this.desired_location = desired_location;
    }
}
