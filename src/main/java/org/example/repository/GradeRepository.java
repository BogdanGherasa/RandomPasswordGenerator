package org.example.repository;

import org.example.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    // Find all grades for a specific student
    List<Grade> findByStudentId(Long studentId);
}
