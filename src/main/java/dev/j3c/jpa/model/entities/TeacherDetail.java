package dev.j3c.jpa.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "teacher_detail")
@NoArgsConstructor
@Getter
@Setter
@ToString
@AllArgsConstructor
@Builder(toBuilder = true)
public class TeacherDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "degree")
    private String degree;

    @OneToOne(mappedBy = "teacherDetail", cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    private Teacher teacher;

    public TeacherDetail removeTeacherDetail() {
        this.getTeacher()
                .setTeacherDetail(null);
        return this;
    }
}
