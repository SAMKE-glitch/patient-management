package com.pm.patientservice.kafka;

import org.springframework.kafka.core.KafkaTemplate;

public class KafkaProducer {

    private final KafkaTemplate<String, byte[]> kafkaTemplate;
}
