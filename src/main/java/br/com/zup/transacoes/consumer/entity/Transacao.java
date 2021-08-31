package br.com.zup.transacoes.consumer.entity;


import br.com.zup.transacoes.consumer.responsemessage.TransacaoResponseTopic;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idtransacao;
    private double valor;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn
    private Estabelecimento estabelecimento;

    @Embedded
    private Cartao cartao;

    private LocalDateTime efetivadaEm;

    public Transacao() {
    }

    public Transacao(TransacaoResponseTopic transacaoResponseTopic) {
        this.idtransacao = transacaoResponseTopic.getId();
        this.valor = transacaoResponseTopic.getValor();
        this.estabelecimento = new Estabelecimento(transacaoResponseTopic.getEstabelecimento());
        this.cartao = new Cartao(transacaoResponseTopic.getCartao());
        this.efetivadaEm = transacaoResponseTopic.getEfetivadaEm();
    }

    public Long getId() {
        return id;
    }

    public String getIdtransacao() {
        return idtransacao;
    }

    public double getValor() {
        return valor;
    }

    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    public Cartao getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
