package br.com.letscode.integracao.produto.service;

import br.com.letscode.integracao.produto.repository.ProdutoRepository;
import br.com.letscode.integracao.produto.entity.Produto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    private ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Produto adicionarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos() {
        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.post
        return (List<Produto>) produtoRepository.findAll();
    }

    public Produto buscarProdutoPorId(Long id) {
        Optional<Produto> optionalProduto = produtoRepository.findById(id);
        if (!optionalProduto.isPresent()) {
            throw new IllegalArgumentException("Produto não encontrado!");
        }
        return optionalProduto.get();
    }

    public Produto removerProduto(Long id) {
        Produto produto = buscarProdutoPorId(id);
        produtoRepository.delete(produto);
        return produto;
    }
}
