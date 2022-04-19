package dev.j3c.jpa;

import dev.j3c.jpa.model.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ActiveProfiles("dev")
@ComponentScan(basePackages = {"dev.j3c.jpa.helpers.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class MySQLIntegrationTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testMySQLConnection() {
        long countBefore = this.studentRepository.count();
        assertThat(countBefore).isEqualTo(3);
    }

}
