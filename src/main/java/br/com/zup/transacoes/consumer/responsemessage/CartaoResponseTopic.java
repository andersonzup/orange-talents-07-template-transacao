package br.com.zup.transacoes.consumer.responsemessage;

public class CartaoResponseTopic {
    private String id;
    private String email;

    @Deprecated
    public CartaoResponseTopic() {
    }

    public CartaoResponseTopic(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}
