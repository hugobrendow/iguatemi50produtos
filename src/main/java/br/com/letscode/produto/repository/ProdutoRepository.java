package br.com.letscode.produto.repository;

import br.com.letscode.produto.entity.Produto;
import org.springframework.data.repository.CrudRepository;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
}
