package br.com.zup.transacoes.compras;

import br.com.zup.transacoes.consumer.entity.Estabelecimento;
import br.com.zup.transacoes.consumer.entity.Transacao;
import br.com.zup.transacoes.consumer.responsemessage.CartaoResponseTopic;
import br.com.zup.transacoes.consumer.responsemessage.EstabelecimentoResponseTopic;

import java.time.LocalDateTime;

public class CompraResponse {
    private String id;
    private double valor;
    private EstabelecimentoResponse estabelecimento;
    private LocalDateTime efetivadaEm;

    @Deprecated
    public CompraResponse() {
    }

    public CompraResponse(Transacao transacao) {
        this.id = transacao.getIdtransacao();
        this.valor = transacao.getValor();
        this.estabelecimento = new EstabelecimentoResponse(transacao.getEstabelecimento());
        this.efetivadaEm = transacao.getEfetivadaEm();
    }

    public CompraResponse(String id, double valor, EstabelecimentoResponse estabelecimento, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimento = estabelecimento;
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

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }
}
