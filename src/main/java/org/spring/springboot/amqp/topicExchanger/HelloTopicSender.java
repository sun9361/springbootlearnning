package org.spring.springboot.amqp.topicExchanger;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloTopicSender {
    @Autowired
    private AmqpTemplate template;
    
    public void send() {
    //template.convertAndSend("queue","hello,rabbit~");
    template.convertAndSend("exchange", "topic.message", "nihao rabbit!");
    }
}