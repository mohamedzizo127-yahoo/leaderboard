package com.example.gadsleaderboard.model;

public class LearningLeader {
    /*
    *
"name": "Kojo Yeboah",
"hours": 90,
"country": "Ghana",
* */
    private String name;
    private int hours;
    private String country;

    public LearningLeader(String name, int hours, String country) {
        this.name = name;
        this.hours = hours;
        this.country = country;
    }

    public LearningLeader() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
