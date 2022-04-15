package dev.j3c.jpa.mappers.implementations;

import dev.j3c.jpa.mappers.ObjectMapper;
import dev.j3c.jpa.model.entities.Student;
import dev.j3c.jpa.web.dto.StudentDto;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper implements ObjectMapper {

    public StudentDto mapFromEntityToDto(Student student) {
        return this.mapFromEntityToDto(student, (Student entity) -> StudentDto
                .builder()
                .id(entity.getId())
                .identification(entity.getIdentification())
                .lastName(entity.getLastName())
                .age(entity.getAge())
                .email(entity.getEmail())
                .courseList(entity.getCourseList())
                .build());
    }

    public Student mapFromDtoToEntity(StudentDto student) {
        return this.mapFromDtoToEntity(student, (StudentDto dto) -> Student
                .builder()
                .id(dto.getId())
                .identification(dto.getIdentification())
                .lastName(dto.getLastName())
                .age(dto.getAge())
                .email(dto.getEmail())
                .courseList(dto.getCourseList())
                .build());
    }
}
