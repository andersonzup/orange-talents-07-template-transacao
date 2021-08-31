package br.com.zup.transacoes.consumer.entity;

import br.com.zup.transacoes.consumer.responsemessage.EstabelecimentoResponseTopic;

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

    public Estabelecimento(EstabelecimentoResponseTopic estabelecimentoResponseTopic) {
        this.nome = estabelecimentoResponseTopic.getNome();
        this.cidade = estabelecimentoResponseTopic.getCidade();
        this.endereco = estabelecimentoResponseTopic.getEndereco();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEndereco() {
        return endereco;
    }
}
