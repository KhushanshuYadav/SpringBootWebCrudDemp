package com.khushanshu.CrudDemoBoot.Controller;


import com.khushanshu.CrudDemoBoot.Entity.Student;
import com.khushanshu.CrudDemoBoot.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //create
    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student studentReq){

        Student studentRes=studentService.insertStudent(studentReq);

        return ResponseEntity.status(HttpStatus.CREATED).body(studentRes);

    }


    //read
    @GetMapping("/read")
    public ResponseEntity<Student> readStudent(@RequestParam long id){

        Optional<Student> studentRes=studentService.selectStudent(id);

        return (studentRes.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build()));
    }

    //update
    @PutMapping("/update")
    public ResponseEntity<Student> updateStudent(@RequestParam long id,@RequestBody Student studentReq){

        Student studentRes=studentService.updateStudent(id,studentReq);

        return (studentRes!=null?ResponseEntity.ok(studentRes):ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam long id){
        Boolean isDeleted = studentService.deleteStudent(id);

        return isDeleted?ResponseEntity.ok("Record deleted"):ResponseEntity.notFound().build();
    }

}
