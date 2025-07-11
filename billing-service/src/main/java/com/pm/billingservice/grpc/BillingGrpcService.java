package com.pm.billingservice.grpc;


import net.devh.boot.grpc.server.service.GrpcService;
import billing.BillingServiceGrpc.BillingServiceImplBase;

@GrpcService
public class BillingGrpcService extends BillingServiceImplBase {
}
