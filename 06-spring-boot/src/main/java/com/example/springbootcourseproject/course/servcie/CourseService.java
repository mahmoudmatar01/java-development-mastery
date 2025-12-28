package com.example.springbootcourseproject.course.servcie;

import com.example.springbootcourseproject.course.entity.Course;

import java.util.List;

public interface CourseService {
    List<Course> findAllCourses();
    Course findCourseById(Long id);
    Course saveCourse(Long topicId,String courseName);
}
