package org.spring.springboot.amqp.fanoutExchanger;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 

@Configuration
public class SenderFanoutConf {
     @Bean(name="Amessage")
     public Queue queueAMessage() {
          return new Queue("fanout.A");
     }
     @Bean(name="Bmessage")
     public Queue queueBMessages() {
          return new Queue("fanout.B");
     }
     @Bean(name="Cmessage")
     public Queue queueCMessages() {
          return new Queue("fanout.C");
     }
     @Bean
     public FanoutExchange  fanoutExchange(){ 	 
    	 return new FanoutExchange("fanoutExchange");
     }
     @Bean
     Binding bindingExchangeA(@Qualifier("Amessage") Queue AMessage,FanoutExchange fanoutExchange) {
         return BindingBuilder.bind(AMessage).to(fanoutExchange);
     }
     @Bean
     Binding bindingExchangeB(@Qualifier("Bmessage") Queue AMessage,FanoutExchange fanoutExchange) {
         return BindingBuilder.bind(AMessage).to(fanoutExchange);
     }
     @Bean
     Binding bindingExchangeC(@Qualifier("Cmessage") Queue AMessage,FanoutExchange fanoutExchange) {
         return BindingBuilder.bind(AMessage).to(fanoutExchange);
     }
}