package dev.j3c.jpa;

import dev.j3c.jpa.model.entities.Teacher;
import dev.j3c.jpa.model.repositories.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SpringDataJpaReviewConceptsApplicationTest {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private TeacherDetailRepository teacherDetailRepository;

    @Autowired
    private CourseReviewRepository courseReviewRepository;

    @Test
    void testBookRepository() {
        List<Teacher> teacherList = this.teacherRepository.findAll();

        //Spring is going to load the entire context for the test --> It'll execute CommandLineRunner
        Assertions.assertThat(teacherList.size()).isEqualTo(1);
        Assertions.assertThat(teacherList.get(0).getCourseList().size()).isEqualTo(1);
    }


}