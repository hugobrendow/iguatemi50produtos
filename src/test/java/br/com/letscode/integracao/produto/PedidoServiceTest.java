package br.com.letscode.integracao.produto;

import br.com.letscode.integracao.produto.service.PedidoService;
import br.com.letscode.integracao.produto.entity.Pedido;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PedidoServiceTest {
    private final Double VALOR_FRETE = 15d;
    @InjectMocks
    private PedidoService pedidoService;

    public Pedido getPedido() {
        return new Pedido(1l, "Fulano", 15, 85.55, "SP");
    }

    @Test
    public void salvarPedidoComFreteDe15Reais() {
        Pedido pedido = getPedido();
        Pedido pedidoSalvo = pedidoService.salvarPedido(pedido);
        assertEquals(pedidoSalvo.getValorTotal(), 100.55);
    }

    @Test
    public void salvarPedidoComDesconto20Porcento() {
        Pedido pedido = getPedido();
        pedido.setValorTotal(520.00);
        Pedido pedidoSalvo = pedidoService.salvarPedido(pedido);
        assertEquals(pedidoSalvo.getValorTotal(), 428d);
    }

    @Test
    public void salvarPedidoDFComFreteGratis() {
        double valorCompra = 95d;
        Pedido pedido = getPedido();
        pedido.setEstado("DF");
        pedido.setValorTotal(valorCompra);
        Pedido pedidoSalvo = pedidoService.salvarPedido(pedido);
        assertEquals(valorCompra + VALOR_FRETE, pedidoSalvo.getValorTotal());
    }

}
