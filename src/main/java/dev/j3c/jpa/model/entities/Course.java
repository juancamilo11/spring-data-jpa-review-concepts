package dev.j3c.jpa.model.entities;

import dev.j3c.jpa.helpers.annotations.CourseCode;
import dev.j3c.jpa.helpers.enums.EnumCareers;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "course_code",
            nullable = false,
            updatable = false,
            length = 50)
    @CourseCode(value = "UdeA-", message = "Course code must start with 'UdeA-'")
    private String courseCode;

    @Column(name = "name",
            nullable = false,
            length = 50)
    private String name;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name = "courseList")
    private Teacher teacher;

    @Column(name = "career",
            nullable = false,
            updatable = true)
    @Enumerated(value = EnumType.STRING)
    private EnumCareers career;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Set<CourseReview> courseReviewList;

    public void addCourseReview(CourseReview courseReview) {
        if(this.courseReviewList == null) {
            this.courseReviewList = new HashSet<>();
        }
        this.courseReviewList.add(courseReview);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Course)) return false;

        Course course = (Course) object;

        return getId().equals(course.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }


}
