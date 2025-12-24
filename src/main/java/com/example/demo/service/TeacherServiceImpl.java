package com.example.demo.service;

import com.example.demo.dto.TeacherDto;
import com.example.demo.entity.TeacherEntity;
import com.example.demo.mapper.TeacherMapper;
import com.example.demo.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final TeacherMapper teacherMapper;

    @Override
    public List<TeacherDto> getAll() {
        return teacherMapper.toDtoList(teacherRepository.findAll());
    }

    @Override
    public TeacherDto getById(Long id) {
        return teacherMapper.toDto(teacherRepository.findById(id).orElse(null));
    }

    @Override
    public void addTeacher(TeacherDto teacherDto) {
        teacherRepository.save(teacherMapper.toEntity(teacherDto));
    }

    @Override
    public void updateTeacher(Long id, TeacherDto teacherDto) {
        TeacherEntity teacher = teacherRepository.findById(id).orElse(null);
        if (teacher != null) {
            teacher.setFullName(teacherDto.getFullName());
            teacher.setSpecialization(teacherDto.getSpecialization());
            teacher.setExperienceYears(teacherDto.getExperienceYears());
            teacherRepository.save(teacher);
        }
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}