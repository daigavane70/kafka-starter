package com.vedant.kafka.demo.controller;

import com.vedant.kafka.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("producer")
public class Producer {

    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "test";

    @GetMapping("/test")
    public HttpEntity test(){
        return new HttpEntity<>("HelloÏ");
    }

    @GetMapping("/test/{message}")
    public HttpEntity produce(@PathVariable("message") String message){
        User user = new User("Vedant", 1, message);
        kafkaTemplate.send(TOPIC, user);
        return new HttpEntity(message);
    }
}
