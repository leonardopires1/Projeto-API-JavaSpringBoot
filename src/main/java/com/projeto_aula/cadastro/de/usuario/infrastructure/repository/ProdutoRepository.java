package com.projeto_aula.cadastro.de.usuario.infrastructure.repository;

import com.projeto_aula.cadastro.de.usuario.infrastructure.entitys.Produto;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
    Optional<Produto> findByNome(String nome);

    @Transactional
    void deleteByNome(String nome);

    Produto findProductByNome(String nome);
}
