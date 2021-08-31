package br.com.zup.transacoes.consumer.entity;

import br.com.zup.transacoes.consumer.responsemessage.CartaoResponse;
import br.com.zup.transacoes.consumer.responsemessage.EstabelecimentoResponse;
import br.com.zup.transacoes.consumer.responsemessage.TransacaoResponse;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idtransacao;
    private double valor;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private Estabelecimento estabelecimento;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn
    private Cartao cartao;


    private LocalDateTime efetivadaEm;

    public Transacao() {
    }

    public Transacao(TransacaoResponse transacaoResponse) {
        this.idtransacao = transacaoResponse.getId();
        this.valor = transacaoResponse.getValor();
        this.estabelecimento = new Estabelecimento(transacaoResponse.getEstabelecimento());
        this.cartao = new Cartao(transacaoResponse.getCartao());
        this.efetivadaEm = transacaoResponse.getEfetivadaEm();
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", idtransacao='" + idtransacao + '\'' +
                ", valor=" + valor +
                ", estabelecimento=" + estabelecimento +
                ", cartao=" + cartao +
                ", efetivadaEm=" + efetivadaEm +
                '}';
    }
}
