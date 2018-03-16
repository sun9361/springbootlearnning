package org.spring.springboot.amqp.fanoutExchanger;

import java.util.UUID;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelloFanoutSender implements  RabbitTemplate.ConfirmCallback{
    @Autowired
    private RabbitTemplate template;
    
    public void send() {
    //template.convertAndSend("queue","hello,rabbit~");
    	template.setConfirmCallback(this);
    	CorrelationData correlationData=new CorrelationData(UUID.randomUUID().toString());
     template.convertAndSend("fanoutExchange", "", "nihao fanout rabbit!",correlationData);
    }

	@Override
	public void confirm(CorrelationData correlationData, boolean ack, String cause) {
	    
        if (ack){
            System.out.println("插入record成功，更改库存成功");
        }else{
        	  System.out.println("插入record失败，更改库存失败");
        }
		
	}
}