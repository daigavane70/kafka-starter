package com.vedant.kafka.demo.listener;

import com.vedant.kafka.demo.model.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    @KafkaListener(topics = "test", groupId = "group_id")
    public void consume(User user){
        System.out.println("ConsumedMessage: "+user);
    }
}
