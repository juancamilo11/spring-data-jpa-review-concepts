package dev.j3c.jpa.web.controllers;

import dev.j3c.jpa.model.entities.Student;
import dev.j3c.jpa.services.StudentService;
import dev.j3c.jpa.web.dto.StudentDto;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping(
            value = "/get/students",
            produces = {"application/json"}
    )
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.studentService.getAllStudents());
    }

    @GetMapping(
            value = "/get/student/{id}",
            produces = {"application/json"}
    )
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("id") Long id) {
        return ResponseEntity.of(this.studentService.getStudentById(id));
    }

    @PostMapping(
            value = "/post/student",
            consumes = {"application/json"},
            produces = {"application/json"}
    )
    public ResponseEntity<StudentDto> postStudent(@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(this.studentService.postStudent(studentDto));
    }

    @DeleteMapping(value = "/put/student/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id") Long id) {
        this.studentService.deleteStudentById(id);
        return ResponseEntity.ok().build();
    }
}
