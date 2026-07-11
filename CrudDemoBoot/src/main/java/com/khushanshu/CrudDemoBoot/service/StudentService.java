package com.khushanshu.CrudDemoBoot.service;

import com.khushanshu.CrudDemoBoot.entity.Student;
import com.khushanshu.CrudDemoBoot.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student insertStudent(Student student) {

        student.setStatus(true);

        return studentRepository.save(student);

    }

    public Optional<Student> selectStudent(Long id) {

        return studentRepository.findByIdAndStatusIsTrue(id);

    }

    public Student updateStudent(Long id, Student studentReq) {

        if (studentRepository.findByIdAndStatusIsTrue(id).isEmpty()) {
            return null;
        }

        studentReq.setId(id);
        studentReq.setStatus(true);
        return studentRepository.save(studentReq);
    }


    public Boolean deleteStudent(Long id) {

        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return true;
        }
        return false;

    }
    
    public Boolean deleteStudentSoftly(Long id){

        if (!studentRepository.existsByIdAndStatusIsTrue(id)) {
            return false;
        }

        Optional<Student> student=studentRepository.findByIdAndStatusIsTrue(id);
        Student studentToSave=student.get();
        studentToSave.setStatus(false);
        studentRepository.save(studentToSave);
        return true;


    }
}
