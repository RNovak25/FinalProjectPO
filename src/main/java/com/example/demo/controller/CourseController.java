package com.example.demo.controller;

import com.example.demo.dto.CourseDto;
import com.example.demo.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(courseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> getById(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(courseService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCourse(@RequestBody CourseDto courseDto) {
        courseService.addCourse(courseDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable("id") Long id,
                                          @RequestBody CourseDto courseDto) {
        courseService.updateCourse(id, courseDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable("id") Long id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}