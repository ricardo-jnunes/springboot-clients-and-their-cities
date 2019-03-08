package com.cities.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

	public static final String ROUTING_KEY = "client";
	public static final String CLIENTS_CITIES_EXCHANGE = "clients_cities_exchange";

	@Bean
	public Queue queue() {
		return new Queue(ROUTING_KEY, false);
	}

	@Bean
	public TopicExchange clientsCitiesExchange() {
		return new TopicExchange(CLIENTS_CITIES_EXCHANGE);
	}

	@Bean
	Binding binding(Queue queue, TopicExchange clientsCitiesExchange) {
		return BindingBuilder.bind(queue).to(clientsCitiesExchange).with(queue.getName());
	}
}
