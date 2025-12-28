package com.example.springbootcourseproject.topic;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TopicController {

    List<Topic>topicList= List.of(
            new Topic(1L,"topic 1"),
            new Topic(2L,"topic 2"),
            new Topic(3L,"topic 3"),
            new Topic(4L,"topic 4"),
            new Topic(5L,"topic 5")
    );

    @RequestMapping(value = "/topics",method = RequestMethod.GET)
    public ResponseEntity<?>findTopics(){
        return ResponseEntity.status(HttpStatus.OK).body(topicList);
    }
}
