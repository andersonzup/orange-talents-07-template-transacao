package br.com.zup.transacoes.consumer;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransacaoConsumer {

    private static final Logger LOGGER_CONSUMER = LoggerFactory.getLogger(TransacaoConsumer.class);

    @Value(value = "${topic.name}")
    private String topic;

    @Value(value = "${spring.kafka.group-id}")
    private String groupId;

    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.group-id}", containerFactory = "transacaoKafkaListenerContainerFactory")
    public void listenTopicCar(ConsumerRecord<String, TransacaoResponse> record){
        LOGGER_CONSUMER.info("Received message in partition " + record.partition());
        LOGGER_CONSUMER.info("Received message with value " + record.value().toString());

    }


}
