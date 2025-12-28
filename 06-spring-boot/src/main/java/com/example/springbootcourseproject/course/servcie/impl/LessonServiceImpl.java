package com.example.springbootcourseproject.course.servcie.impl;

import com.example.springbootcourseproject.course.entity.Course;
import com.example.springbootcourseproject.course.entity.Lesson;
import com.example.springbootcourseproject.course.repository.CourseRepository;
import com.example.springbootcourseproject.course.repository.LessonRepository;
import com.example.springbootcourseproject.course.servcie.CourseService;
import com.example.springbootcourseproject.course.servcie.LessonService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class LessonServiceImpl implements LessonService {


    private final LessonRepository lessonRepository;
    private final CourseRepository courseRepository;


    @Override
    public Lesson saveLesson(String lessonName, Long courseId) {
        Course course=courseRepository.findById(courseId).get();
        Lesson lesson=Lesson
                .builder()
                .lessonName(lessonName)
                .course(course)
                .build();
        lesson=lessonRepository.save(lesson);

        course.getLessonList().add(lesson);
        return lesson;
    }

    @Override
    public List<Lesson> findAllLessons() {
        return lessonRepository.findAll();
    }
}
