package ors.spring.springboot.amqp.test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

public class NotSpringMQConsumer {

	public static void main(String[] args) throws IOException, TimeoutException {
		 
		
		ConnectionFactory factory =new ConnectionFactory();
		 
		Connection connection=factory.newConnection();
		Channel channel=connection.createChannel();
		channel.queueDeclare("task_queue", true, false, true, null);
		 System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
		 channel.basicQos(1); // accept only one unack-ed message at a time (see below)
		Consumer consumer = new DefaultConsumer(channel) {
			  @Override
			  public void handleDelivery(String consumerTag, Envelope envelope,
			                             AMQP.BasicProperties properties, byte[] body)
			      throws IOException {
			    String message = new String(body, "UTF-8");
			    System.out.println(" [x] Received '" + message + "'");
			  
			  
			  try {
			      doWork(message);
			    } finally {
			      System.out.println(" [x] Done");
			      channel.basicNack(envelope.getDeliveryTag(),false, false);
			    }
			  }

			private void doWork(String message) {
				// TODO Auto-generated method stub
				for (char ch: message.toCharArray()) {
			        if (ch == '.')
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			    }
			}
			};
//			channel.basicConsume("Hello", true, consumer);
			
			boolean autoAck = false;//手动确认
			channel.basicConsume("task_queue", autoAck, consumer);
		
	}

}
