package com.example.demo.service;

import com.example.demo.dto.CourseDto;
import com.example.demo.entity.CourseEntity;
import com.example.demo.mapper.CourseMapper;
import com.example.demo.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public List<CourseDto> getAll() {
        return courseMapper.toDtoList(courseRepository.findAll());
    }

    @Override
    public CourseDto getById(Long id) {
        return courseMapper.toDto(courseRepository.findById(id).orElse(null));
    }

    @Override
    public void addCourse(CourseDto courseDto) {
        courseRepository.save(courseMapper.toEntity(courseDto));
    }

    @Override
    public void updateCourse(Long id, CourseDto courseDto) {
        CourseEntity course = courseRepository.findById(id).orElse(null);
        if (course != null) {
            course.setCourseName(courseDto.getCourseName());
            course.setDescription(courseDto.getDescription());
            course.setDurationMonths(courseDto.getDurationMonths());
            courseRepository.save(course);
        }
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}