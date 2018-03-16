package org.spring.springboot.amqp.topicExchanger;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.rabbitmq.client.AMQP.Channel;
@Component
public class receiverMessage {
	@RabbitListener(queues="topic.message")    //监听器监听指定的Queue
	    public void process1(String str) {    
	        System.out.println("message:"+str);
	    }
	    @RabbitListener(queues="topic.messages")    //监听器监听指定的Queue
	    public void process2(String str,Channel channel) {
	    
	        System.out.println("messages:"+str);
	    }
}

