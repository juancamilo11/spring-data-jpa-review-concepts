package dev.j3c.jpa.services;

import dev.j3c.jpa.web.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAllStudents();

}
