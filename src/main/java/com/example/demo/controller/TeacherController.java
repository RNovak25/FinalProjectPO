package com.example.demo.controller;

import com.example.demo.dto.TeacherDto;
import com.example.demo.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(teacherService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(teacherService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTeacher(@RequestBody TeacherDto teacherDto) {
        teacherService.addTeacher(teacherDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTeacher(@PathVariable("id") Long id,
                                           @RequestBody TeacherDto teacherDto) {
        teacherService.updateTeacher(id, teacherDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeacher(@PathVariable("id") Long id) {
        teacherService.deleteTeacher(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}