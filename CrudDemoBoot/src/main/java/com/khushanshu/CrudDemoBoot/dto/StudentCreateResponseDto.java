package com.khushanshu.CrudDemoBoot.dto;

import java.time.LocalDateTime;

public class StudentCreateResponseDto {



    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Integer rollNo;
    private String subject;
    private LocalDateTime createDateTime;


    public StudentCreateResponseDto(Long id,String name, Integer age, String email, Integer rollNo, String subject, LocalDateTime createDateTime) {
        this.id=id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.rollNo = rollNo;
        this.subject = subject;
        this.createDateTime = createDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }
}


