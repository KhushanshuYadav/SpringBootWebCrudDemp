package com.khushanshu.CrudDemoBoot.Service;

import com.khushanshu.CrudDemoBoot.Entity.Student;
import com.khushanshu.CrudDemoBoot.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student insertStudent(Student student) {

        return studentRepository.save(student);

    }

    public Optional<Student> selectStudent(long id) {

        return studentRepository.findById(id);

    }

    public Student updateStudent(long id, Student studentReq) {

        if (studentRepository.findById(id).isEmpty()) {
            return null;
        }

        studentReq.setId(id);
        return studentRepository.save(studentReq);
    }


    public Boolean deleteStudent(long id) {

        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return true;
        }
        return false;

    }
}
