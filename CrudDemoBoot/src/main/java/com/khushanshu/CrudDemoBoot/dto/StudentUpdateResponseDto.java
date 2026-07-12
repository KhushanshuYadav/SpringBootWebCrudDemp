package com.khushanshu.CrudDemoBoot.dto;

import java.time.LocalDateTime;

public class StudentUpdateResponseDto {

    private String name;
    private Integer age;
    private Integer rollNo;
    private String subject;
    private LocalDateTime updateDateTime;


    public StudentUpdateResponseDto(String name, Integer age, Integer rollNo, String subject, LocalDateTime updateDateTime) {
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
        this.subject = subject;
        this.updateDateTime = updateDateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getRollNo() {
        return rollNo;
    }

    public void setRollNo(Integer rollNo) {
        this.rollNo = rollNo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }
}
