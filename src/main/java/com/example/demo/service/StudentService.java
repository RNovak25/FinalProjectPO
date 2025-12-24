package com.example.demo.service;

import com.example.demo.dto.StudentDto;
import java.util.List;

public interface StudentService {
    List<StudentDto> getAll();
    StudentDto getById(Long id);
    void addStudent(StudentDto studentDto);
    void updateStudent(Long id, StudentDto studentDto);
    void deleteStudent(Long id);
}