package com.khushanshu.CrudDemoBoot.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class StudentUpdateRequestDto {

    @NotBlank(message = "Name is mandatory")
    private String name;

    @Positive(message = "Age Cannot be -ve")
    @Min(value = 18, message = "Age must be > 18 ")
    @NotNull
    private Integer age;

    @NotNull(message = "Roll no cannot be empty")
    private Integer rollNo;

    private String subject;

    public StudentUpdateRequestDto(String name, Integer age, Integer rollNo, String subject) {
        this.name = name;
        this.age = age;
        this.rollNo = rollNo;
        this.subject = subject;
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
}
