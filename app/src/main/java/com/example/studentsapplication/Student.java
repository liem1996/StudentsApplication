package com.example.studentsapplication;

public class Student {

    String name;
    String id;
    Boolean isCheck;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getCheck() {
        return isCheck;
    }

    public void setCheck(Boolean check) {
        isCheck = check;
    }

    public Student(String name, String id, Boolean isCheck) {
        this.name = name;
        this.id = id;
        this.isCheck = isCheck;
    }
    public Student() {

    }
}
