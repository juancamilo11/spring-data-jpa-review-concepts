package dev.j3c.jpa.web.controllers;

import dev.j3c.jpa.services.StudentService;
import dev.j3c.jpa.web.dto.StudentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping(value = "/get/students", produces = {"application/json"})
    public List<StudentDto> getAllStudents() {
        return this.studentService.getAllStudents();
    }
}
