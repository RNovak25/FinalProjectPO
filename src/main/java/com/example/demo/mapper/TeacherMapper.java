package com.example.demo.mapper;

import com.example.demo.dto.TeacherDto;
import com.example.demo.entity.TeacherEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {

    TeacherDto toDto(TeacherEntity teacherEntity);

    TeacherEntity toEntity(TeacherDto teacherDto);

    List<TeacherDto> toDtoList(List<TeacherEntity> teacherEntityList);
}