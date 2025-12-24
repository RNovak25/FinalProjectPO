package com.example.demo.service;

import com.example.demo.dto.TeacherDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;

    @Test
    void addAndGetTeacherTest() {
        TeacherDto teacher = new TeacherDto(null, "Mr. Test", "Math", 5);
        teacherService.addTeacher(teacher);
        List<TeacherDto> all = teacherService.getAll();
        Assertions.assertFalse(all.isEmpty());
        TeacherDto last = all.get(all.size() - 1);
        Assertions.assertEquals("Mr. Test", last.getFullName());
    }

    @Test
    void updateTeacherTest() {
        teacherService.addTeacher(new TeacherDto(null, "OldTeacher", "Hist", 1));
        List<TeacherDto> all = teacherService.getAll();
        Long id = all.get(all.size() - 1).getId();
        TeacherDto updateInfo = new TeacherDto(id, "NewTeacher", "Hist", 2);
        teacherService.updateTeacher(id, updateInfo);
        TeacherDto updated = teacherService.getById(id);
        Assertions.assertEquals("NewTeacher", updated.getFullName());
    }

    @Test
    void deleteTeacherTest() {
        teacherService.addTeacher(new TeacherDto(null, "DelTeacher", "Hist", 1));
        List<TeacherDto> all = teacherService.getAll();
        Long id = all.get(all.size() - 1).getId();
        teacherService.deleteTeacher(id);
        Assertions.assertNull(teacherService.getById(id));
    }
}