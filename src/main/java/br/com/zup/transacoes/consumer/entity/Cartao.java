package br.com.zup.transacoes.consumer.entity;


import br.com.zup.transacoes.consumer.responsemessage.CartaoResponse;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cartao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String idcartao;

    private String email;

    @OneToMany
    private List<Transacao> transacao;

    public Cartao() {
    }

    public Cartao(CartaoResponse cartaoResponse) {
        this.idcartao = cartaoResponse.getId();
        this.email = cartaoResponse.getEmail();
    }
}
