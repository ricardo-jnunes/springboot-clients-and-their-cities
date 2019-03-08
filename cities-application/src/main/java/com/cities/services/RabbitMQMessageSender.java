package com.cities.services;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cities.configuration.RabbitMQConfiguration;

@Service
public class RabbitMQMessageSender {

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Autowired
	private Queue queue;

	public void send(String value) {
		rabbitTemplate.convertAndSend(RabbitMQConfiguration.CLIENTS_CITIES_EXCHANGE, this.queue.getName(), value);
	}
}
