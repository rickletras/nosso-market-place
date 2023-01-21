package br.com.zup.edu.marketplace.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProdutoProducer {
    @Autowired
    private KafkaTemplate<String, Produto> kafkaTemplate;

    @Value ("${spring.kafka.producer.topic}")
    private String topico;

    public void send(Produto produto){
        kafkaTemplate.send(topico, produto);
    }
}
