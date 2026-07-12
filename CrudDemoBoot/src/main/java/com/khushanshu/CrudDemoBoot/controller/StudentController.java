package com.khushanshu.CrudDemoBoot.controller;


import com.khushanshu.CrudDemoBoot.dto.StudentCreateRequestDto;
import com.khushanshu.CrudDemoBoot.dto.StudentCreateResponseDto;
import com.khushanshu.CrudDemoBoot.dto.StudentUpdateRequestDto;
import com.khushanshu.CrudDemoBoot.dto.StudentUpdateResponseDto;
import com.khushanshu.CrudDemoBoot.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {



    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //create
    @PostMapping()
    public ResponseEntity<StudentCreateResponseDto> createStudent(@Valid @RequestBody StudentCreateRequestDto studentCreateRequestDto){

        StudentCreateResponseDto studentCreateResponseDto=studentService.insertStudent(studentCreateRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(studentCreateResponseDto);

    }


    //read
    @GetMapping()
    public ResponseEntity<StudentCreateResponseDto> readStudent(@RequestParam long id){

        StudentCreateResponseDto studentCreateResponseDto=studentService.selectStudent(id);

        return ResponseEntity.ok(studentCreateResponseDto);

    }

    //update
    @PutMapping()
    public ResponseEntity<StudentUpdateResponseDto> updateStudent(@RequestParam long id, @Valid @RequestBody StudentUpdateRequestDto studentUpdateRequestDto){

        StudentUpdateResponseDto studentUpdateResponseDto=studentService.updateStudent(id, studentUpdateRequestDto);

        return ResponseEntity.ok(studentUpdateResponseDto);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteStudent(@RequestParam long id){
        
        studentService.deleteStudent(id);

        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/soft-delete")
    public ResponseEntity<String> softDeleteStudent(@RequestParam long id){
        studentService.deleteStudentSoftly(id);

        return ResponseEntity.noContent().build();
    }

}
