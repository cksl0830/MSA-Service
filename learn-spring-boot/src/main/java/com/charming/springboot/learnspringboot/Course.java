package com.charming.springboot.learnspringboot;

public class Course {
    private long id;
    private String name;

    public Course(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    @Override

    public String toString() {
        return "Course{" + "id=" + id + ", name='" + name + '\'' + '}';
    }

    public String getName() {
        return name;
    }
}
