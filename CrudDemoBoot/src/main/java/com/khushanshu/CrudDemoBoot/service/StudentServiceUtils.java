package com.khushanshu.CrudDemoBoot.service;

import com.khushanshu.CrudDemoBoot.dto.StudentCreateRequestDto;
import com.khushanshu.CrudDemoBoot.dto.StudentCreateResponseDto;
import com.khushanshu.CrudDemoBoot.dto.StudentUpdateRequestDto;
import com.khushanshu.CrudDemoBoot.dto.StudentUpdateResponseDto;
import com.khushanshu.CrudDemoBoot.entity.Student;

import java.time.LocalDateTime;

public class StudentServiceUtils {

    private StudentServiceUtils() {
    }

    public static Student mapToEntity(StudentCreateRequestDto studentCreateRequestDto) {

        Student student = new Student();
        student.setName(studentCreateRequestDto.getName());
        student.setAge(studentCreateRequestDto.getAge());
        student.setEmail(studentCreateRequestDto.getEmail());
        student.setRollNo(studentCreateRequestDto.getRollNo());
        student.setSubject(studentCreateRequestDto.getSubject());
        return student;
    }

    public static StudentCreateResponseDto mapToDto(Student student) {
        return new StudentCreateResponseDto(
                student.getName(),
                student.getAge(),
                student.getEmail(),
                student.getRollNo(),
                student.getSubject(),
                LocalDateTime.now()
        );
    }

    public static Student mapToEntity(StudentUpdateRequestDto studentUpdateRequestDto, Student student) {
        student.setName(studentUpdateRequestDto.getName());
        student.setAge(studentUpdateRequestDto.getAge());
        student.setRollNo(studentUpdateRequestDto.getRollNo());
        student.setSubject(studentUpdateRequestDto.getSubject());
        return student;
    }

    public static StudentUpdateResponseDto mapToUpdateDto(Student student) {
        return new StudentUpdateResponseDto(
                student.getName(),
                student.getAge(),
                student.getRollNo(),
                student.getSubject(),
                LocalDateTime.now()
        );
    }
}
