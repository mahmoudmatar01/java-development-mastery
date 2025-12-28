package com.example.springbootcourseproject.course.servcie;

import com.example.springbootcourseproject.course.entity.Topics;

import java.util.List;

public interface TopicService {
    List<Topics>findAllTopics();
    Topics getTopicById(Long id);
    Topics saveTopic(String topicName);
    Topics  updateTopic(Long id, String newName) ;
    String removeTopics(Long id);
}
