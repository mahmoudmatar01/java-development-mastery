package com.example.springbootcourseproject.course.controller;

import com.example.springbootcourseproject.course.entity.Course;
import com.example.springbootcourseproject.course.servcie.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/all")
    public List<Course> getAllCourses() {
        return courseService.findAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable Long id) {
        return courseService.findCourseById(id);
    }

    @PostMapping("/save")
    public Course saveCourse(@RequestParam Long topicId, @RequestParam String courseName) {
        return courseService.saveCourse(topicId, courseName);
    }
}
