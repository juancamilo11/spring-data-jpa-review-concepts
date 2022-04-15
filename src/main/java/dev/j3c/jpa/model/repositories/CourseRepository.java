package dev.j3c.jpa.model.repositories;

import dev.j3c.jpa.model.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}