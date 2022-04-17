package dev.j3c.jpa;

import dev.j3c.jpa.model.entities.Student;
import dev.j3c.jpa.model.entities.Teacher;
import dev.j3c.jpa.model.repositories.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@DataJpaTest
class SpringDataJpaTestSlice {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void testTeacherRepository() {
        Teacher teacher = Teacher.builder()
                .identification("123")
                .firstName("Lucas")
                .lastName("Marin")
                .age(40)
                .email("lucas.marin123@udea.edu.co")
                .teacherDetail(null)
                .courseList(new HashSet<>())
                .build();

        long teacherCount = this.teacherRepository.count();
        //Spring is not loading the entire context for the test
        Assertions.assertThat(teacherCount).isZero();

        this.teacherRepository.save(teacher);
        Assertions.assertThat(teacherCount).isEqualTo(1L);



    }

}
