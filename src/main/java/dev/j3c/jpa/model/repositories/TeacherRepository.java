package dev.j3c.jpa.model.repositories;

import dev.j3c.jpa.model.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}