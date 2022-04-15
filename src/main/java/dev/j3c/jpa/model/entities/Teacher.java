package dev.j3c.jpa.model.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "teacher")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "identification",
            nullable = false,
            updatable = false,
            length = 50)
    private String identification;

    @Column(name = "first_name",
            nullable = false,
            length = 50)
    private String firstName;

    @Column(name = "last_name",
            nullable = false,
            length = 50)
    private String lastName;

    @Column(name = "age",
            nullable = false)
    private int age;

    @Column(name = "email",
            nullable = false,
            updatable = false,
            unique = true,
            length = 100)
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


















