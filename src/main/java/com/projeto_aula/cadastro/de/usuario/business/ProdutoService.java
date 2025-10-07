package com.projeto_aula.cadastro.de.usuario.business;

import com.projeto_aula.cadastro.de.usuario.infrastructure.entitys.Produto;
import com.projeto_aula.cadastro.de.usuario.infrastructure.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
    private final ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public void salvarProduto(Produto produto) {
        repository.saveAndFlush(produto);
    }

    public Produto buscarPorNome(String nome) {
        return repository.findByNome(nome).orElseThrow(
                () -> new RuntimeException("Produto não encontrado")
        );
    }

    public void deletarProdutoPorNome(String nome) {
        repository.deleteByNome(nome);
    }

    public void atualizarProduto(Produto produto, String nome) {
        Produto produtoEntity = repository.findProductByNome(nome);
        Produto produtoAtualizado = Produto.builder()
                .id(produtoEntity.getId())
                .nome(produto.getNome() != null ? produto.getNome() : produtoEntity.getNome())
                .descricao(produto.getDescricao() != null ? produto.getDescricao() : produtoEntity.getDescricao())
                .preco(produto.getPreco() != null ? produto.getPreco() : produtoEntity.getPreco())
                .estoque(produto.getEstoque() != null ? produto.getEstoque() : produtoEntity.getEstoque())
                .build();

        repository.saveAndFlush(produtoAtualizado);
    }
}
