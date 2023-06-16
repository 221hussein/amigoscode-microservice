package com.hussein.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public record CustomerService(CustomerRepository customerRepository) {

//    @Autowired
//    public CustomerService (CustomerRepository customerRepository){
//        this.customerRepository = customerRepository;
//    }

    public void registerCustomer(CustomerRegistrationRequest request) {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        //        todo check if email is valid
        //        todo check if email not taken
        //        todo store customer in db
                customerRepository.save(customer);
    }
}
