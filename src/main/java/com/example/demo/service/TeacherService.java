package com.example.demo.service;

import com.example.demo.dto.TeacherDto;
import java.util.List;

public interface TeacherService {
    List<TeacherDto> getAll();
    TeacherDto getById(Long id);
    void addTeacher(TeacherDto teacherDto);
    void updateTeacher(Long id, TeacherDto teacherDto);
    void deleteTeacher(Long id);
}