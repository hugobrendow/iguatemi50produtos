package br.com.letscode.produto.controller;

import br.com.letscode.produto.entity.Produto;
import br.com.letscode.produto.service.ProdutoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/produtos")
public class ProdutoController {
    private ProdutoService produtoService;
    public ProdutoController(ProdutoService productService) {
        this.produtoService = productService;
    }

    @PostMapping
    public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto product) {
        Produto produtoSalvo = produtoService.adicionarProduto(product);
        return new ResponseEntity<>(produtoSalvo, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos(){
        return new ResponseEntity<>(produtoService.listarProdutos(),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable("id") Long id){
        return new ResponseEntity<>(produtoService.buscarProdutoPorId(id),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Produto> removerProduto(@PathVariable("id") Long id) {
        Produto produto = produtoService.removerProduto(id);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }
}