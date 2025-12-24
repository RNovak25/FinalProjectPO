package com.example.demo.service;

import com.example.demo.dto.StudentDto;
import com.example.demo.entity.StudentEntity;
import com.example.demo.mapper.StudentMapper;
import com.example.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public List<StudentDto> getAll() {
        return studentMapper.toDtoList(studentRepository.findAll());
    }

    @Override
    public StudentDto getById(Long id) {
        return studentMapper.toDto(studentRepository.findById(id).orElse(null));
    }

    @Override
    public void addStudent(StudentDto studentDto) {
        studentRepository.save(studentMapper.toEntity(studentDto));
    }

    @Override
    public void updateStudent(Long id, StudentDto studentDto) {
        StudentEntity student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setFirstName(studentDto.getFirstName());
            student.setLastName(studentDto.getLastName());
            student.setAge(studentDto.getAge());
            student.setEmail(studentDto.getEmail());
            studentRepository.save(student);
        }
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}