package com.pm.analyticsservice.kafka;


import com.google.protobuf.InvalidProtocolBufferException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import patient.events.PatientEvent;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "patient", groupId = "analytics-service")
    public void consumeEvent(byte[] event){

        try {
            PatientEvent patientEvent = PatientEvent.parseFrom(event);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException(e);
        }

    }
}
