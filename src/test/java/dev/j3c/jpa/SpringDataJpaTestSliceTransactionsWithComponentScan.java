package dev.j3c.jpa;

import dev.j3c.jpa.model.entities.Teacher;
import dev.j3c.jpa.model.repositories.TeacherRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;

import java.util.HashSet;

@DataJpaTest //This annotation will only load the necessary context for the DB interaction test
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ComponentScan(basePackages = {"dev.j3c.jpa.helpers.bootstrap"})
//With @ComponentScan we're loading the boostrap class Component, so the CommandLineRunner method will be executed and the DB will be populated
class SpringDataJpaTestSliceTransactionsWithComponentScan {

    @Autowired
    private TeacherRepository teacherRepository;

    @Order(1)
    @Rollback(value = false) // Transaction test won't be commited
//    @Commit --> We can use this annotation or Rollback(value = false)
    @Test
    void testTeacherRepositoryTransaction1() {
        long teacherCountBefore = this.teacherRepository.count();
        //Spring is not loading the entire context for the test
        Assertions.assertThat(teacherCountBefore).isZero();

        Teacher teacher = Teacher.builder()
                .identification("123")
                .firstName("Juan Camilo")
                .lastName("Cardona")
                .age(40)
                .email("lucas.marin123@udea.edu.co")
                .teacherDetail(null)
                .courseList(new HashSet<>())
                .build();

        this.teacherRepository.save(teacher);
        long teacherCountAfter = this.teacherRepository.count();

        Assertions.assertThat(teacherCountAfter).isGreaterThan(teacherCountBefore);
    }

    @Test
    @Order(2)
    void testTeacherRepositoryTransaction2() {
        long teacherCountAfter = this.teacherRepository.count();
        Assertions.assertThat(teacherCountAfter).isEqualTo(1L);

        Teacher teacher = Teacher.builder()
                .identification("123")
                .firstName("Lucas")
                .lastName("Marin")
                .age(40)
                .email("lucas.marin123@udea.edu.co")
                .teacherDetail(null)
                .courseList(new HashSet<>())
                .build();


    }

}
