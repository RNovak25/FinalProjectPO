package com.example.demo.mapper;

import com.example.demo.dto.TeacherDto;
import com.example.demo.entity.TeacherEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class TeacherMapperTest {

    @Autowired
    private TeacherMapper teacherMapper;

    @Test
    void convertEntityToDtoTest() {
        TeacherEntity entity = new TeacherEntity();
        entity.setId(1L);
        entity.setFullName("Dr. Smith");
        entity.setSpecialization("Computer Science");
        entity.setExperienceYears(10);
        TeacherDto dto = teacherMapper.toDto(entity);
        Assertions.assertNotNull(dto);
        Assertions.assertEquals(entity.getId(), dto.getId());
        Assertions.assertEquals(entity.getFullName(), dto.getFullName());
        Assertions.assertEquals(entity.getSpecialization(), dto.getSpecialization());
        Assertions.assertEquals(entity.getExperienceYears(), dto.getExperienceYears());
    }

    @Test
    void convertDtoToEntityTest() {
        TeacherDto dto = new TeacherDto(1L, "Dr. Smith", "CS", 10);
        TeacherEntity entity = teacherMapper.toEntity(dto);
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(dto.getId(), entity.getId());
        Assertions.assertEquals(dto.getFullName(), entity.getFullName());
        Assertions.assertEquals(dto.getSpecialization(), entity.getSpecialization());
        Assertions.assertEquals(dto.getExperienceYears(), entity.getExperienceYears());
    }

    @Test
    void convertEntityListToDtoListTest() {
        List<TeacherEntity> entityList = new ArrayList<>();
        entityList.add(new TeacherEntity(1L, "T1", "Spec1", 5));
        entityList.add(new TeacherEntity(2L, "T2", "Spec2", 8));
        List<TeacherDto> dtoList = teacherMapper.toDtoList(entityList);
        Assertions.assertNotNull(dtoList);
        Assertions.assertEquals(entityList.size(), dtoList.size());
    }
}