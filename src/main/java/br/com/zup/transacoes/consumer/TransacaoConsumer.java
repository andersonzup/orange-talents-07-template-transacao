package br.com.zup.transacoes.consumer;


import br.com.zup.transacoes.consumer.entity.Transacao;
import br.com.zup.transacoes.consumer.entity.TransacaoRepository;
import br.com.zup.transacoes.consumer.responsemessage.TransacaoResponseTopic;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransacaoConsumer {

    private TransacaoRepository transacaoRepository;

    @Value(value = "${topic.name}")
    private String topic;

    @Value(value = "${spring.kafka.group-id}")
    private String groupId;

    public TransacaoConsumer(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}", containerFactory = "transacaoKafkaListenerContainerFactory")
    public void listenTopicCar(ConsumerRecord<String, TransacaoResponseTopic> record) {
        transacaoRepository.save(new Transacao(record.value()));
    }


}
