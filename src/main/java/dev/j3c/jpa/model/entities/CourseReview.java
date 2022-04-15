package dev.j3c.jpa.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "course_review")
@NoArgsConstructor
@Getter
@Setter
@ToString
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
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof CourseReview)) return false;

        CourseReview that = (CourseReview) object;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
