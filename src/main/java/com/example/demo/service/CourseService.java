package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import java.util.List;

public interface CourseService {
    List<CourseDto> getAll();
    CourseDto getById(Long id);
    CourseDto addCourse(CourseDto courseDto);
    void updateCourse(Long id, CourseDto courseDto);
    void deleteCourse(Long id);
}