package dev.j3c.jpa.model.entities;

import dev.j3c.jpa.helpers.annotations.EmailDomain;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "student")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "identification",
            nullable = false,
            updatable = false,
            unique = true)
    private String identification;

    @Column(name = "first_name",
            nullable = false)
    private String firstName;

    @Column(name = "last_name",
            nullable = false)
    private String lastName;

    @Column(name = "age",
            nullable = false)
    @Min(value = 1, message = "Min age must be greater than 0.")
    private int age;

    @Column(name = "email",
            nullable = false,
            updatable = false,
            unique = true)
    @EmailDomain(value = "udea.edu.co", message = "Email domain must be 'udea.edu.co'")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "detail_student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    @ToString.Exclude
    private Set<Course> courseList;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Student)) return false;
        Student student = (Student) object;
        return getIdentification().equals(student.getIdentification());
    }

    @Override
    public int hashCode() {
        return getIdentification().hashCode();
    }

}
