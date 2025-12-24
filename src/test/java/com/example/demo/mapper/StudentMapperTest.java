package com.example.demo.mapper;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.StudentEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    void convertEntityToDtoTest() {
        StudentEntity entity = new StudentEntity();
        entity.setId(1L);
        entity.setFirstName("John");
        entity.setLastName("Doe");
        entity.setAge(20);
        entity.setEmail("john@test.com");
        StudentDto dto = studentMapper.toDto(entity);
        Assertions.assertNotNull(dto);
        Assertions.assertEquals(entity.getId(), dto.getId());
        Assertions.assertEquals(entity.getFirstName(), dto.getFirstName());
        Assertions.assertEquals(entity.getLastName(), dto.getLastName());
        Assertions.assertEquals(entity.getAge(), dto.getAge());
        Assertions.assertEquals(entity.getEmail(), dto.getEmail());
    }

    @Test
    void convertDtoToEntityTest() {
        StudentDto dto = new StudentDto(1L, "John", "Doe", 20, "john@test.com");
        StudentEntity entity = studentMapper.toEntity(dto);
        Assertions.assertNotNull(entity);
        Assertions.assertEquals(dto.getId(), entity.getId());
        Assertions.assertEquals(dto.getFirstName(), entity.getFirstName());
        Assertions.assertEquals(dto.getLastName(), entity.getLastName());
        Assertions.assertEquals(dto.getAge(), entity.getAge());
        Assertions.assertEquals(dto.getEmail(), entity.getEmail());
    }

    @Test
    void convertEntityListToDtoListTest() {
        List<StudentEntity> entityList = new ArrayList<>();
        entityList.add(new StudentEntity(1L, "John", "Doe", 20, "john@test.com"));
        entityList.add(new StudentEntity(2L, "Jane", "Smith", 22, "jane@test.com"));
        List<StudentDto> dtoList = studentMapper.toDtoList(entityList);
        Assertions.assertNotNull(dtoList);
        Assertions.assertEquals(entityList.size(), dtoList.size());
        Assertions.assertEquals(entityList.get(0).getFirstName(), dtoList.get(0).getFirstName());
    }
}