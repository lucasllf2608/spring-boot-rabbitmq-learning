package com.estudos.rabbitmq.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class PedidoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String descricao;
	private Double valor;
	
}
 