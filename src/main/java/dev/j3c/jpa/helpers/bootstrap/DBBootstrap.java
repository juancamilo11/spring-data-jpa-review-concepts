package dev.j3c.jpa.helpers.bootstrap;

import dev.j3c.jpa.helpers.enums.EnumCareers;
import dev.j3c.jpa.model.entities.*;
import dev.j3c.jpa.model.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DBBootstrap implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    private final TeacherDetailRepository teacherDetailRepository;
    private final CourseReviewRepository courseReviewRepository;

    @Override
    public void run(String... args) throws Exception {

        CourseReview courseReview = CourseReview.builder()
                .comment("The course was amazing!")
                .date(LocalDateTime.now())
                .build();

        Course course = Course.builder()
                .courseCode("UdeA-123")
                .name("Matemáticas Discretas I")
                .courseReviewList(Set.of(courseReview))
                .teacher(null)
                .career(EnumCareers.MATH)
                .build();

        TeacherDetail teacherDetail = TeacherDetail.builder()
                .teacher(null)
                .degree("Ingeniero Agrónomo")
                .youtubeChannel("https://youtube.com/AgroCiencia")
                .build();

        Teacher teacher = Teacher.builder()
                .identification("123")
                .firstName("Lucas")
                .lastName("Marin")
                .age(40)
                .email("lucas.marin123@udea.edu.co")
                .teacherDetail(null)
                .courseList(Set.of(course))
                .build();

        teacher.setTeacherDetail(teacherDetail);
        teacherDetail.setTeacher(teacher);
        course.setTeacher(teacher);

        this.teacherRepository.save(teacher);
        this.teacherDetailRepository.save(teacherDetail);
        this.courseRepository.save(course);

    }
}
