package br.com.zup.transacoes.consumer.entity;


import br.com.zup.transacoes.consumer.responsemessage.CartaoResponseTopic;

import javax.persistence.*;

@Embeddable
public class Cartao {

    private String idcartao;

    private String email;

    public Cartao() {
    }

    public Cartao(CartaoResponseTopic cartaoResponseTopic) {
        this.idcartao = cartaoResponseTopic.getId();
        this.email = cartaoResponseTopic.getEmail();
    }

    public String getIdcartao() {
        return idcartao;
    }

    public String getEmail() {
        return email;
    }
}
