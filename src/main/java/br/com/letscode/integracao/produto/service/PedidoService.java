package br.com.letscode.integracao.produto.service;

import br.com.letscode.integracao.produto.entity.Pedido;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {
    private final Double DESCONTO_ACIMA_500 = 0.20;

    public Pedido salvarPedido(Pedido pedido) {
        adicionaFrete(pedido);
        aplicaDesconto(pedido);
        return pedido;
    }

    public Pedido adicionaFrete(Pedido pedido) {
        if (pedido.getValorTotal() < 100 || !pedido.getEstado().equals("DF")) {
            pedido.setValorTotal(pedido.getValorTotal() + 15);
        }
        return pedido;
    }

    public Pedido aplicaDesconto(Pedido pedido) {
        if (pedido.getValorTotal() > 500) {
            double desconto = pedido.getValorTotal() * DESCONTO_ACIMA_500;
            pedido.setValorTotal(pedido.getValorTotal() - desconto);
        }
        return pedido;
    }
}
