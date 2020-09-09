package com.example.gadsleaderboard.model;

public class SkillIqLeader {
    /*
    * "name": "Perry Oluwatobi",
"score": 170,
"country": "Nigeria",
* */
    private String name;
    private int score;
    private String country;

    public SkillIqLeader(String name, int score, String country) {
        this.name = name;
        this.score = score;
        this.country = country;
    }

    public SkillIqLeader() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
