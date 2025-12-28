package com.example.springbootcourseproject.course.repository;

import com.example.springbootcourseproject.course.entity.Topics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicsRepository extends JpaRepository<Topics,Long> {
}
