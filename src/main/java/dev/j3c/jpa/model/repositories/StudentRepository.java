package dev.j3c.jpa.model.repositories;

import dev.j3c.jpa.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}