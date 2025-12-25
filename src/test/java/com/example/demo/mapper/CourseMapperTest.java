package com.example.demo.mapper;

import com.example.demo.dto.CourseDto;
import com.example.demo.entity.CourseEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CourseMapperTest {

    @Autowired
    private CourseMapper courseMapper;

    @Test
    void convertEntityToDtoTest() {
        CourseEntity entity = new CourseEntity();
        entity.setId(1L);
        entity.setCourseName("Java Basics");
        entity.setDescription("Intro to Java");
        entity.setDurationMonths(3);
        CourseDto dto = courseMapper.toDto(entity);
        Assertions.assertNotNull(dto);
        Assertions.assertEquals(entity.getId(), dto.getId());
        Assertions.assertEquals(entity.getCourseName(), dto.getCourseName());
        Assertions.assertEquals(entity.getDescription(), dto.getDescription());
        Assertions.assertEquals(entity.getDurationMonths(), dto.getDurationMonths());
    }

    @Test
    void convertDtoToEntityTest() {
        CourseDto dto = new CourseDto(1L, "Java Basics", "Intro to Java", 3);
        CourseEntity entity = courseMapper.toEntity(dto);
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(dto.getId(), entity.getId());
        Assertions.assertEquals(dto.getCourseName(), entity.getCourseName());
        Assertions.assertEquals(dto.getDescription(), entity.getDescription());
        Assertions.assertEquals(dto.getDurationMonths(), entity.getDurationMonths());
    }

    @Test
    void convertEntityListToDtoListTest() {
        List<CourseEntity> entityList = new ArrayList<>();
        entityList.add(new CourseEntity(1L, "Java", "Desc", 3, null));
        entityList.add(new CourseEntity(2L, "Python", "Desc", 2, null));
        List<CourseDto> dtoList = courseMapper.toDtoList(entityList);
        Assertions.assertNotNull(dtoList);
        Assertions.assertEquals(entityList.size(), dtoList.size());
    }
}