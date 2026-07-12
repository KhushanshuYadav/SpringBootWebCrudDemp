package com.khushanshu.CrudDemoBoot.service;

import com.khushanshu.CrudDemoBoot.dto.StudentCreateRequestDto;
import com.khushanshu.CrudDemoBoot.dto.StudentCreateResponseDto;
import com.khushanshu.CrudDemoBoot.dto.StudentUpdateRequestDto;
import com.khushanshu.CrudDemoBoot.dto.StudentUpdateResponseDto;
import com.khushanshu.CrudDemoBoot.entity.Student;
import com.khushanshu.CrudDemoBoot.exception.DuplicateResourceException;
import com.khushanshu.CrudDemoBoot.exception.ResourceNotFoundException;
import com.khushanshu.CrudDemoBoot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public StudentCreateResponseDto insertStudent(StudentCreateRequestDto studentCreateRequestDto) {

        if (studentRepository.existsByEmail(studentCreateRequestDto.getEmail())) throw new DuplicateResourceException("Student with email " + studentCreateRequestDto.getEmail() + " already exists");

        Student student =StudentServiceUtils.mapToEntity(studentCreateRequestDto);

        student.setStatus(true);

        return StudentServiceUtils.mapToDto(studentRepository.save(student));

    }

    public StudentCreateResponseDto selectStudent(Long id) {


        return StudentServiceUtils.mapToDto(studentRepository.findByIdAndStatusIsTrue(id).orElseThrow( ()->new ResourceNotFoundException("Student not found with id = "+id)));

    }

    public StudentUpdateResponseDto updateStudent(Long id, StudentUpdateRequestDto studentUpdateRequestDto) {

        Student student =studentRepository.findByIdAndStatusIsTrue(id).orElseThrow(()->new ResourceNotFoundException("Student not found with id = "+id));
        StudentServiceUtils.mapToEntity(studentUpdateRequestDto, student);
        student.setId(id);
        student.setStatus(true);
        return StudentServiceUtils.mapToUpdateDto(studentRepository.save(student));
    }


    public void deleteStudent(Long id) {

        Student student=studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student not found with id = "+id));
        studentRepository.delete(student);


    }
    
    public void deleteStudentSoftly(Long id){

        Student student=studentRepository.findByIdAndStatusIsTrue(id).orElseThrow(()->new ResourceNotFoundException("Student not found with id = "+id));
        student.setStatus(false);
        studentRepository.save(student);

    }
}
