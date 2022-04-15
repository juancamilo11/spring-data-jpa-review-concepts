package dev.j3c.jpa.services.implementations;

import dev.j3c.jpa.mappers.implementations.StudentMapper;
import dev.j3c.jpa.model.repositories.StudentRepository;
import dev.j3c.jpa.services.StudentService;
import dev.j3c.jpa.web.dto.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    //TODO --> Use pagination to retrieve all students
    @Override
    public List<StudentDto> getAllStudents() {
        return this.studentRepository.findAll()
                .stream()
                .map(this.studentMapper::mapFromEntityToDto)
                .collect(Collectors.toList());
    }



}
