package com.cities.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

	private static final String CLIENT = "client";

	@Bean
	public Queue queue() {
		return new Queue(CLIENT, true);
	}
}
