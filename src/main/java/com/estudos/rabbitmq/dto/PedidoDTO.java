package com.estudos.rabbitmq.dto;

import java.io.Serializable;

public record PedidoDTO(String id, String descricao, Double valor) implements Serializable {
    private static final long serialVersionUID = 1L;
}