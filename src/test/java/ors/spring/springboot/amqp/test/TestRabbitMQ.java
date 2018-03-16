package ors.spring.springboot.amqp.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.springboot.Application;
import org.spring.springboot.amqp.directExchanger.HelloSender;
import org.spring.springboot.amqp.fanoutExchanger.HelloFanoutSender;
import org.spring.springboot.amqp.topicExchanger.HelloTopicSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes=Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestRabbitMQ {
    
    @Autowired
    private HelloSender helloSender;
    @Autowired
    private HelloTopicSender helloTopicSender;
    @Autowired
    private HelloFanoutSender helloFanoutSender;

    @Test
    public void testRabbit() {
        helloSender.send();
    }
    @Test
    public void testTopicRabbit() {
    	helloTopicSender.send();
    }
    @Test
    public void testFanouRabbit() {
    	helloFanoutSender.send();
    }
}