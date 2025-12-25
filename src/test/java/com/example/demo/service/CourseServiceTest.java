package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import com.example.demo.model.UserModel;
import com.example.demo.rep.UserRep;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import java.util.List;

@SpringBootTest
public class CourseServiceTest {

    @Autowired
    private CourseService courseService;

    @Autowired
    private UserRep userRep;

    @Test
    @WithMockUser(username = "teacher@gmail.com", roles = "TEACHER")
    void addAndGetCourseTest() {
        createTestUser("teacher@gmail.com");
        CourseDto newCourse = new CourseDto(null, "Math", "Hard math", 6);
        courseService.addCourse(newCourse);
        List<CourseDto> all = courseService.getAll();
        Assertions.assertFalse(all.isEmpty());
        CourseDto last = all.get(all.size() - 1);
        Assertions.assertEquals("Math", last.getCourseName());
    }

    @Test
    @WithMockUser(username = "teacher@gmail.com", roles = "TEACHER")
    void updateCourseTest() {
        createTestUser("teacher@gmail.com");
        courseService.addCourse(new CourseDto(null, "OldName", "Desc", 1));
        List<CourseDto> all = courseService.getAll();
        Long id = all.get(all.size() - 1).getId();
        CourseDto updateInfo = new CourseDto(id, "NewName", "NewDesc", 2);
        courseService.updateCourse(id, updateInfo);
        CourseDto updated = courseService.getById(id);
        Assertions.assertEquals("NewName", updated.getCourseName());
    }

    @Test
    @WithMockUser(username = "teacher@gmail.com", roles = "TEACHER")
    void deleteCourseTest() {
        createTestUser("teacher@gmail.com");
        courseService.addCourse(new CourseDto(null, "DeleteMe", "Desc", 1));
        List<CourseDto> all = courseService.getAll();
        Long id = all.get(all.size() - 1).getId();
        courseService.deleteCourse(id);
        Assertions.assertNull(courseService.getById(id));
    }

    private void createTestUser(String email) {
        if (userRep.findByEmail(email) == null) {
            UserModel user = new UserModel();
            user.setEmail(email);
            user.setPassword("123");
            user.setUsername("TeacherName");
            userRep.save(user);
        }
    }
}