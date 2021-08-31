package br.com.zup.transacoes.consumer.entity;

import br.com.zup.transacoes.consumer.responsemessage.EstabelecimentoResponse;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estabelecimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cidade;

    private String endereco;

    public Estabelecimento() {
    }

    public Estabelecimento(EstabelecimentoResponse estabelecimentoResponse) {
        this.nome = estabelecimentoResponse.getNome();
        this.cidade = estabelecimentoResponse.getCidade();
        this.endereco = estabelecimentoResponse.getEndereco();
    }





}
