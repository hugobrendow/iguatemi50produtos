package br.com.letscode.integracao.produto.steps;

import br.com.letscode.integracao.produto.entity.Pedido;
import br.com.letscode.integracao.produto.service.PedidoService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

public class PedidoSteps extends BaseTestStep {
    Pedido pedido;

    @Autowired
    PedidoService pedidoService;

    @Given("que eu tenha um pedido com o valor de {double} reais")
    public void que_eu_tenha_um_pedido_com_o_valor_de_reais(Double valor) {
        pedido = new Pedido(null, "Hugo", 2, valor, null);
    }

    @Given("o cliente eh do DF")
    public void o_cliente_eh_do_df() {
        pedido.setEstado("DF");
    }

    @When("salvar um pedido")
    public void salvar_um_pedido() {
        pedido = pedidoService.salvarPedido(pedido);
    }

    @Then("o pedido tem que ter acrescentado o frete")
    public void o_pedido_tem_que_ter_acrescentado_o_frete() {
        Assert.assertEquals(pedido.getValorTotal(), Double.valueOf(65));
    }

    @Given("o cliente eh do RJ")
    public void o_cliente_eh_do_rj() {
        pedido.setEstado("RJ");
    }

    @Then("o valor tem que ser mantido")
    public void o_valor_tem_que_ser_mantido() {
        Assert.assertEquals(pedido.getValorTotal(), Double.valueOf(150));
    }

    @Then("o valor tem que ser de {double}")
    public void o_valor_tem_que_ser_de(Double valor) {
        Assert.assertEquals(pedido.getValorTotal(), valor);
    }


}
