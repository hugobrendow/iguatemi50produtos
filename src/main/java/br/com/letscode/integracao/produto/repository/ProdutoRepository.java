package br.com.letscode.integracao.produto.repository;

import br.com.letscode.integracao.produto.entity.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
