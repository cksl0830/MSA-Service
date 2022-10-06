package com.rest.webservices.restfulwebservices.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class User {
    private Integer id;
    @NotNull
    @Size(min = 2, message = "2글자 이상 입력하세요.")
    private String name;
    @NotNull(message = "팀을 입력하세요.")
    private String team;
    @NotNull(message = "생년월일을 입력하세요.")
    private LocalDate birth;

    public User(Integer id, String name, String team, LocalDate birth) {
        this.id = id;
        this.name = name;
        this.team = team;
        this.birth = birth;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public void setBirth(LocalDate birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + ", team='" + team + '\'' + ", birth=" + birth + '}';
    }
}
