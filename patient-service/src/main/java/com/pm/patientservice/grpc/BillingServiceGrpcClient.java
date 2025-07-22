package com.pm.patientservice.grpc;


import billing.BillingRequest;
import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
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

        ManagedChannel channel = ManagedChannelBuilder.forAddress(serverAdress, serverPort).usePlaintext().build();

        blockingStub = BillingServiceGrpc.newBlockingStub(channel);
    }

    public BillingResponse createBillingAccount(String patiendId, String name, String email) {
        BillingRequest request = BillingRequest.newBuilder().setPatientId(patiendId).setName(name).setEmail(email).build();

        BillingResponse response = blockingStub.createBillingAccount(request);

        log.info("Received response for billing service via GRPC: {}", response);
    }
}
