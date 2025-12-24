package com.example.demo.mapper;

import com.example.demo.dto.CourseDto;
import com.example.demo.entity.CourseEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    CourseDto toDto(CourseEntity courseEntity);

    CourseEntity toEntity(CourseDto courseDto);

    List<CourseDto> toDtoList(List<CourseEntity> courseEntityList);
}