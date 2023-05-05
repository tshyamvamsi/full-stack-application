package com.shyamlearning.customer;

public record CustomerUpdateRequest(
    String name,
    String email,
    Integer age){
}
