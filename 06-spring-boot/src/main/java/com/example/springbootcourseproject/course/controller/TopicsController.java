package com.example.springbootcourseproject.course.controller;

import com.example.springbootcourseproject.course.entity.Topics;
import com.example.springbootcourseproject.course.servcie.TopicService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topic")
@RequiredArgsConstructor
public class TopicsController {

    private final TopicService courseService;

    @GetMapping("/all")
    public List<Topics> getAllTopics() {
        return courseService.findAllTopics();
    }

    @GetMapping("/{id}")
    public Topics getTopicById(@PathVariable Long id) {
        return courseService.getTopicById(id);
    }

    @PostMapping("/save/{topicName}")
    public Topics saveTopic(@PathVariable String topicName) {
        return courseService.saveTopic(topicName);
    }

    @PutMapping("/update/{id}")
    public Topics updateTopic(@PathVariable Long id, @RequestParam String newName) {
        return courseService.updateTopic(id, newName);
    }

    @DeleteMapping("/remove/{id}")
    public String removeTopic(@PathVariable Long id) {
        return courseService.removeTopics(id);
    }
}
