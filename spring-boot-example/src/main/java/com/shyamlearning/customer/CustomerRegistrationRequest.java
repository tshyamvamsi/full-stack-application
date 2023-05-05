package com.shyamlearning.customer;

public record CustomerRegistrationRequest (
        String name,
        String email,
        Integer age
){


}
