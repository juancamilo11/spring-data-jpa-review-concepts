package dev.j3c.jpa.model.entities;

import dev.j3c.jpa.helpers.annotations.EmailDomain;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teacher")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "identification",
            nullable = false,
            updatable = false)
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
            unique = true,
            length = 100)
    @EmailDomain(value = "udea.edu.co", message = "Email domain must be 'udea.edu.co'")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_detail_id")
    private TeacherDetail teacherDetail;

    @OneToMany(mappedBy = "teacher",cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    }, fetch = FetchType.EAGER)
    private Set<Course> courseList;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Teacher)) return false;
        Teacher teacher = (Teacher) object;
        return getIdentification().equals(teacher.getIdentification());
    }

    @Override
    public int hashCode() {
        return getIdentification().hashCode();
    }

    public void addCourse(Course course) {
        if(this.courseList == null) {
            this.courseList = new HashSet<>();
        }
        this.courseList.add(course);
        course.setTeacher(this);
    }

}



















