package br.com.letscode.integracao.produto.steps;

import br.com.letscode.integracao.produto.ProdutoApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
        classes = ProdutoApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class BaseTestStep {
}
