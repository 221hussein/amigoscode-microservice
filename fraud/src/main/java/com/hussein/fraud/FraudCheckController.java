package com.hussein.fraud;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/fraud-check")
public class FraudCheckController {
    private final FraudCheckHistoryService fraudCheckHistoryService;

    public FraudCheckController(FraudCheckHistoryService fraudCheckHistoryService) {
        this.fraudCheckHistoryService = fraudCheckHistoryService;
    }
    @PostMapping(path = "{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable ("customerId") Integer customerId){
        boolean isfraudulent  = fraudCheckHistoryService.isFraudulentCustomer(customerId);
        return new FraudCheckResponse(isfraudulent);
    }
}
