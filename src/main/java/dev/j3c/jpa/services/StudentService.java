package dev.j3c.jpa.services;

import dev.j3c.jpa.web.dto.StudentDto;

import java.util.List;
import java.util.Optional;

public interface StudentService {

    List<StudentDto> getAllStudents();
    Optional<StudentDto> getStudentById(Long id);
    StudentDto postStudent(StudentDto studentDto);
    void deleteStudentById(Long id);
}
