package br.com.zup.transacoes.consumer.responsemessage;

import java.time.LocalDateTime;

public class TransacaoResponseTopic {
    private String id;
    private double valor;
    private EstabelecimentoResponseTopic estabelecimento;
    private CartaoResponseTopic cartao;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public TransacaoResponseTopic() {
    }

    public TransacaoResponseTopic(String id, double valor, EstabelecimentoResponseTopic estabelecimento, CartaoResponseTopic cartao, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
        this.cartao = cartao;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public double getValor() {
        return valor;
    }

    public EstabelecimentoResponseTopic getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoResponseTopic getCartao() {
        return cartao;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    @Override
    public String toString() {
        return "TransacaoResponse{" +
                "id='" + id + '\'' +
                "\n, valor=" + valor +
                "\n, estabelecimentoResponse=" + estabelecimento +
                "\n, cartao=" + cartao +
                "\n, efetivadaEm=" + efetivadaEm +
                '}';
    }
}
