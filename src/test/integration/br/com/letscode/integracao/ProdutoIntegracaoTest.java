package br.com.letscode.integracao;

import br.com.letscode.integracao.produto.ProdutoApplication;
import br.com.letscode.integracao.produto.entity.Pedido;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes = ProdutoApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProdutoIntegracaoTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void salvarProduto() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/produtos")
                        .content(converterObjetoParaJson(new Pedido(null, "Teste", 15, 85.55, "SP")))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    public static String converterObjetoParaJson(final Pedido obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
