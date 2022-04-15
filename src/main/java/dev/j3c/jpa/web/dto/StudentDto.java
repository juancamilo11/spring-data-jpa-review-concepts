package dev.j3c.jpa.web.dto;

import dev.j3c.jpa.helpers.annotations.EmailDomain;
import dev.j3c.jpa.model.entities.Course;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder(toBuilder = true)
public class StudentDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Null(message = "Id value must be null")
    private Long id;

    @NotEmpty(message = "Identification cannot be empty")
    private String identification;

    @Size(min = 5, max=50, message = "first name must be between 5 and 50 characters")
    private String firstName;

    @Size(min = 5, max=50, message = "last name must be between 5 and 50 characters")
    private String lastName;

    @Min(value = 1, message = "Min age must be greater than 0.")
    @Max(value = 120, message = "Min age must be less than 120.")
    private int age;

    @NotBlank(message = "Email value cannot be blank")
    @EmailDomain(value = "udea.edu.co", message = "Email domain must be 'udea.edu.co'")
    private String email;

    @NotNull(message = "Course list cannot be null")
    private Set<Course> courseList;

}
