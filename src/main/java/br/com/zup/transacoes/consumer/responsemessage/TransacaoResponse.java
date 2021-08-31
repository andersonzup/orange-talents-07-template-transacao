package br.com.zup.transacoes.consumer.responsemessage;

import java.time.LocalDateTime;

public class TransacaoResponse {
    private String id;
    private double valor;
    private EstabelecimentoResponse estabelecimento;
    private CartaoResponse cartao;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public TransacaoResponse() {
    }

    public TransacaoResponse(String id, double valor, EstabelecimentoResponse estabelecimento, CartaoResponse cartao, LocalDateTime efetivadaEm) {
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

    public EstabelecimentoResponse getEstabelecimento() {
        return estabelecimento;
    }

    public CartaoResponse getCartao() {
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
