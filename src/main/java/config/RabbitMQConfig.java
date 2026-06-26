package config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
	
	public static final String QUEUE_PEDIDOS = "pedidos.v1.criar-pedido";
	public static final String EXCHANGE_PEDIDOS = "pedidos.v1.exchange";
	public static final String ROUTING_KEY_PEDIDOS = "criar-pedidos";
 
	@Bean
	public Queue queue() {
		return new Queue(QUEUE_PEDIDOS, true);
	}
	
	@Bean
	public DirectExchange exchange() {
		return new DirectExchange(EXCHANGE_PEDIDOS);
	}
	
	@Bean
	public Binding binding(Queue queue, DirectExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY_PEDIDOS);
	} 
	
	public MessageConverter jsonMessageConverter() {
		return new JacksonJsonMessageConverter();
	}
	
}
