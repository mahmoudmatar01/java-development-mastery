package com.example.springbootcourseproject.course.controller;

import com.example.springbootcourseproject.course.entity.Lesson;
import com.example.springbootcourseproject.course.servcie.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @PostMapping("/save")
    public Lesson saveLesson(@RequestParam String lessonName, @RequestParam Long courseId) {
        return lessonService.saveLesson(lessonName, courseId);
    }

    @GetMapping("/all")
    public List<Lesson> findAllLessons() {
        return lessonService.findAllLessons();
    }
}