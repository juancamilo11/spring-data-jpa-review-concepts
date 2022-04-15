package dev.j3c.jpa.model.repositories;

import dev.j3c.jpa.model.entities.TeacherDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherDetailRepository extends JpaRepository<TeacherDetail, Long> {
}