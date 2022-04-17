package dev.j3c.jpa.model.entities;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "course_review")
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder(toBuilder = true)
public class CourseReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "comment",
            nullable = false,
            updatable = false)
    @Lob
    private String comment;

    @Column(name = "date",
            nullable = false,
            updatable = false)
    @Lob
    @DateTimeFormat(style = "yyyy-MM-dd")
    private LocalDateTime date;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseReview)) return false;

        CourseReview that = (CourseReview) o;

        return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
