package br.com.zup.transacoes.consumer.entity;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {


    Slice<Transacao> findAllByCartao_Idcartao(String id, Pageable pageable);

    boolean existsByCartao_Idcartao(String id);
}
