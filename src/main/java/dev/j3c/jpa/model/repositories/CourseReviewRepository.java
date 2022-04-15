package dev.j3c.jpa.model.repositories;

import dev.j3c.jpa.model.entities.CourseReview;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseReviewRepository extends JpaRepository<CourseReview, Long> {
}