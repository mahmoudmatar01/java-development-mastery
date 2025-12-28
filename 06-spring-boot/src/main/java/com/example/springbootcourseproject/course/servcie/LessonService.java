package com.example.springbootcourseproject.course.servcie;

import com.example.springbootcourseproject.course.entity.Lesson;

import java.util.List;

public interface LessonService {
    Lesson saveLesson(String lessonName,Long courseId);
    List<Lesson> findAllLessons();
}
