package com.hussein.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {

}
