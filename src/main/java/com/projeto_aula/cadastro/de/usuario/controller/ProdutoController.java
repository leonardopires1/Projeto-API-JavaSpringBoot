package com.projeto_aula.cadastro.de.usuario.controller;

import com.projeto_aula.cadastro.de.usuario.business.ProdutoService;
import com.projeto_aula.cadastro.de.usuario.infrastructure.entitys.Produto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {
    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Void> salvarProduto(@RequestBody Produto produto) {
        produtoService.salvarProduto(produto);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<Produto> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(produtoService.buscarPorNome(nome));
    }

    @PutMapping
    public ResponseEntity<Void> atualizarProduto(@RequestBody Produto produto, @RequestParam String nome) {
        produtoService.atualizarProduto(produto, nome);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> deletarProdutoPorNome(@RequestParam String nome) {
        produtoService.deletarProdutoPorNome(nome);
        return ResponseEntity.ok().build();
    }
}
