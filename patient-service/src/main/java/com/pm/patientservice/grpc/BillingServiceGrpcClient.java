package com.pm.patientservice.grpc;


import billing.BillingServiceGrpc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class BillingServiceGrpcClient {
    private static final Logger log = LoggerFactory.getLogger(BillingServiceGrpcClient.class);
    private final BillingServiceGrpc.BillingServiceBlockingStub blockingStub;

    public BillingServiceGrpcClient(@Value("${billing.service.address:localhost}") String serverAdress, @Value("${billing.service.grpc.port:9001}") int serverPort) {
        log.info("Connecting to Billing Service GRPC Service at: {}:{}", serverAdress, serverPort);
    }
}
