package com.estudos.rabbitmq.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.rabbitmq.config.RabbitMQConfig;
import com.estudos.rabbitmq.dto.PedidoDTO;

@RestController
@RequestMapping("/v1/pedidos")
public class PedidoController {
	
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@PostMapping
	public ResponseEntity<String> enviarPedido(@RequestBody PedidoDTO pedido){
		rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_PEDIDOS, RabbitMQConfig.ROUTING_KEY_PEDIDOS, pedido);
		return ResponseEntity.ok("Pedido Enviado com sucesso enviado para o Rabbit");
	}

}
