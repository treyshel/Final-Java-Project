package com.example.backend.Core;

public class StudentAchievements {
    public Integer id;
    public Integer student_id;
    public String programming_langs;
    public String bio;
    public String academics;
    public String interests;

    public StudentAchievements() {}
    public StudentAchievements(Integer id, Integer student_id, String programming_langs, String bio, String academics, String interests) {
        this.id = id;
        this.student_id = student_id;
        this.programming_langs = programming_langs;
        this.bio = bio;
        this.academics = academics;
        this.interests = interests;
    }
}
