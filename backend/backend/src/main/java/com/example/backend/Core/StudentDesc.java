package com.example.backend.Core;

public class StudentDesc {
    public String programming_langs;
    public String academics;
    public String desired_location;

    public StudentDesc(){}

    public StudentDesc(String programming_langs, String academics, String desired_location) {
        this.programming_langs = programming_langs;
        this.academics = academics;
        this.desired_location = desired_location;
    }
}
