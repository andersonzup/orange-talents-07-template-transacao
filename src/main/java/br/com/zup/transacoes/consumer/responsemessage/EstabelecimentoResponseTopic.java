package br.com.zup.transacoes.consumer.responsemessage;

import br.com.zup.transacoes.consumer.entity.Estabelecimento;

public class EstabelecimentoResponseTopic {
    private String nome;
    private String cidade;
    private String endereco;

    @Deprecated
    public EstabelecimentoResponseTopic() {
    }

    public EstabelecimentoResponseTopic(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
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
