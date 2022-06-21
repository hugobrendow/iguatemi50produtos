package br.com.letscode.integracao.produto;

import br.com.letscode.integracao.produto.repository.ProdutoRepository;
import br.com.letscode.integracao.produto.service.ProdutoService;
import br.com.letscode.integracao.produto.entity.Produto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProdutoServiceTest {
    @Mock
    private ProdutoRepository produtoRepository;

    @Autowired
    @InjectMocks
    private ProdutoService produtoService;
    private Produto produto1;
    private Produto produto2;
    List<Produto> produtoLista;

    @BeforeEach
    public void setUp() {
        produtoLista = new ArrayList<>();
        produto1 = new Produto(1l, "TV 55", "TV 55 POLEGADAS LED, LG", 500l);
        produto2 = new Produto(2l, "TV 48", "TV 48 POLEGADAS LCD, LG", 500l);
        produtoLista.add(produto1);
        produtoLista.add(produto2);
    }

    @Test
    void buscarProdutoPorIdTest() {
        when(produtoRepository.findById(1l)).thenReturn(Optional.of(produto1));
        Produto produto = produtoService.buscarProdutoPorId(1l);
        assertEquals(produto.getDescricao(), produto1.getDescricao());
        assertEquals(produto.getId(), produto1.getId());
        assertEquals(produto.getNome(), produto1.getNome());
        assertEquals(produto.getUnidades(), produto1.getUnidades());
    }

    @Test
    void adicionarProdutoTest() {
        when(produtoRepository.save(Mockito.any())).thenReturn(produto2);
        Produto produto = produtoService.adicionarProduto(produto2);
        assertEquals(produto.getDescricao(), produto2.getDescricao());
        assertEquals(produto.getId(), produto2.getId());
        assertEquals(produto.getNome(), produto2.getNome());
        assertEquals(produto.getUnidades(), produto2.getUnidades());
    }

    @Test
    void removerProdutoTest() {
        doNothing().when(produtoRepository).delete(Mockito.any());
        when(produtoRepository.findById(2l)).thenReturn(Optional.of(produto2));
        Produto produto = produtoService.removerProduto(2l);
        assertEquals(produto.getId(), produto2.getId());
    }

    @Test
    void listarProdutosTest() {
        when(produtoRepository.findAll()).thenReturn(produtoLista);
        List<Produto> produtos = produtoService.listarProdutos();
        assertEquals(produtos.size(), 2);
    }

    @Test
    void buscarUsuarioPorIdNaoEncontradoTest() {
        when(produtoRepository.findById(1l)).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class, () -> produtoService.buscarProdutoPorId(1l));
    }

    @Test
    void removerProdutoNaoEncontradoTest() {
        when(produtoRepository.findById(1l)).thenReturn(Optional.empty());
        assertThrows(IllegalArgumentException.class, () -> produtoService.removerProduto(1l));
    }

}
