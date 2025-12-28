package com.example.springbootcourseproject.course.servcie.impl;

import com.example.springbootcourseproject.course.entity.Course;
import com.example.springbootcourseproject.course.entity.Topics;
import com.example.springbootcourseproject.course.repository.CourseRepository;
import com.example.springbootcourseproject.course.repository.TopicsRepository;
import com.example.springbootcourseproject.course.servcie.CourseService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final TopicsRepository topicsRepository;
    @Override
    public List<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course findCourseById(Long id) {
        Course course=courseRepository.findById(id).orElseThrow(
                ()->new RuntimeException("There is no course with that id : "+id)
        );
        return course;
    }

    @Override
    public Course saveCourse(Long topicId, String courseName) {
        Topics topics=topicsRepository.findById(topicId).orElseThrow(
                ()->new RuntimeException("There is no topic with that id : "+topicId)
        );
        Course course=Course
                .builder()
                .courseDescription("Course Description")
                .courseName(courseName)
                .topic(topics)
                .build();
        course=courseRepository.save(course);
        topics.getCourseList().add(course);
        topicsRepository.save(topics);
        return course;
    }
}
