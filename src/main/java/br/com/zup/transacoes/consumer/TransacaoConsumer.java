package br.com.zup.transacoes.consumer;


import br.com.zup.transacoes.consumer.entity.Transacao;
import br.com.zup.transacoes.consumer.entity.TransacaoRepository;
import br.com.zup.transacoes.consumer.responsemessage.TransacaoResponse;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransacaoConsumer {

    TransacaoRepository transacaoRepository;

    private static final Logger LOGGER_CONSUMER = LoggerFactory.getLogger(TransacaoConsumer.class);

    @Value(value = "${topic.name}")
    private String topic;

    @Value(value = "${spring.kafka.group-id}")
    private String groupId;

    public TransacaoConsumer(TransacaoRepository transacaoRepository) {
        this.transacaoRepository = transacaoRepository;
    }

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}", containerFactory = "transacaoKafkaListenerContainerFactory")
    public void listenTopicCar(ConsumerRecord<String, TransacaoResponse> record) {
        Transacao transacao = transacaoRepository.save(new Transacao(record.value()));
        System.out.println(transacao.toString());
    }


}
