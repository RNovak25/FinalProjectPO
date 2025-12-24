package com.example.demo.service;

import com.example.demo.dto.StudentDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    void addAndGetStudentTest() {
        StudentDto newStudent = new StudentDto(null, "TestName", "TestLast", 20, "test@mail.com");
        studentService.addStudent(newStudent);
        List<StudentDto> all = studentService.getAll();
        Assertions.assertFalse(all.isEmpty());
        StudentDto lastAdded = all.get(all.size() - 1);
        Assertions.assertEquals("TestName", lastAdded.getFirstName());
    }

    @Test
    void updateStudentTest() {

        StudentDto student = new StudentDto(null, "BeforeUpdate", "Last", 20, "email");
        studentService.addStudent(student);
        List<StudentDto> all = studentService.getAll();
        Long id = all.get(all.size() - 1).getId();
        StudentDto updateInfo = new StudentDto(id, "AfterUpdate", "Last", 21, "email");
        studentService.updateStudent(id, updateInfo);
        StudentDto updated = studentService.getById(id);
        Assertions.assertEquals("AfterUpdate", updated.getFirstName());
        Assertions.assertEquals(21, updated.getAge());
    }

    @Test
    void deleteStudentTest() {

        StudentDto student = new StudentDto(null, "ToDelete", "Last", 20, "email");
        studentService.addStudent(student);
        List<StudentDto> all = studentService.getAll();
        Long id = all.get(all.size() - 1).getId();
        studentService.deleteStudent(id);
        StudentDto deleted = studentService.getById(id);
        Assertions.assertNull(deleted);
    }
}