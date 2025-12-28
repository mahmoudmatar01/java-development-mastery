package com.example.springbootcourseproject.course.servcie.impl;

import com.example.springbootcourseproject.course.entity.Topics;
import com.example.springbootcourseproject.course.repository.TopicsRepository;
import com.example.springbootcourseproject.course.servcie.TopicService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class TopicServiceImpl implements TopicService {

    private final TopicsRepository topicsRepository;
    @Override
    public List<Topics> findAllTopics() {
        List<Topics>topics=topicsRepository.findAll();
        return topics;
    }

    @Override
    public Topics getTopicById(Long id) {
        Topics topic=topicsRepository.findById(id).orElseThrow(
                ()->new RuntimeException("There is no topic with that id : "+id)
        );
        return topic;
    }

    @Override
    public Topics saveTopic(String topicName) {
        Topics topics=Topics.builder()
                .topicName(topicName)
                .courseList(new ArrayList<>())
                .build();
        topics=topicsRepository.save(topics);
        return topics;
    }

    @Override
    public Topics updateTopic(Long id, String newName) {
        Topics topic=topicsRepository.findById(id).orElseThrow(
                ()->new RuntimeException("There is no topic with that id : "+id)
        );
        topic.setTopicName(newName);
        topicsRepository.save(topic);
        return topic;
    }

    @Override
    public String removeTopics(Long id) {
        Topics topic=topicsRepository.findById(id).orElseThrow(
                ()->new RuntimeException("There is no topic with that id : "+id)
        );
        topicsRepository.delete(topic);
        return "Topic with id : "+id+" was deleted successfully";
    }
}
