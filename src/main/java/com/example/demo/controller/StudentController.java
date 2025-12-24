package com.example.demo.controller;

import com.example.demo.dto.StudentDto;
import com.example.demo.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(studentService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addStudent(@RequestBody StudentDto studentDto) {
        studentService.addStudent(studentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable("id") Long id,
                                           @RequestBody StudentDto studentDto) {
        studentService.updateStudent(id, studentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("id") Long id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}