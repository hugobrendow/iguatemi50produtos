package br.com.letscode.integracao.produto.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pedido {
    private Long id;
    private String cliente;
    private Integer quantidadeProdutos;
    private Double valorTotal;
    private String estado;
}
