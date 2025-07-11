package com.pm.billingservice.grpc;


import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import billing.BillingServiceGrpc.BillingServiceImplBase;

@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {
    @Override
    public void createBillingAcount(billing.BillingRequest billingRequest, StreamObserver<billing.BillingResponse> responseStreamObserver){

    }
}
