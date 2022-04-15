package dev.j3c.jpa.services.implementations;

import dev.j3c.jpa.model.repositories.StudentRepository;
import dev.j3c.jpa.services.StudentService;
import dev.j3c.jpa.web.dto.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<StudentDto> getAllStudents() {
        return this.studentRepository.findAll();
    }

}
