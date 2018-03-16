package ors.spring.springboot.amqp.test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class NotSpringMQSender {

	public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
		 
		
		ConnectionFactory factory =new ConnectionFactory();
		 
		Connection connection=factory.newConnection();
		Channel channel=connection.createChannel();
		boolean durable = true;
		//channel.queueDeclare("task_queue1", durable, false, false, null);
		channel.queueDeclare("task_queue", true, false, true, null);
		channel.confirmSelect();
		String message="Hello.World....";
				//channel.basicPublish("", "task_queue1", null, message.getBytes());
				System.out.println(" [x] Sent '" + message + "'");
				channel.basicPublish("", "task_queue",
			            MessageProperties.PERSISTENT_TEXT_PLAIN,
			            message.getBytes());
				System.out.println(channel.waitForConfirms());
				channel.close();
				connection.close();
		
	}

}
