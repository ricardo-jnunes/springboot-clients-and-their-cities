package com.clients.listeners;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQListener {
	private static final String CLIENT = "client";

	@RabbitListener(queues = { CLIENT })
	public void receive(@Payload String fileBody) {
		System.out.println("Client: " + fileBody);
	}
}
