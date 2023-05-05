package com.shyamlearning.customer;

import java.util.List;
import java.util.Optional;


public interface CustomerDAO {
    List<Customer> selectAllCustomers();
    Optional<Customer> selectCustomerById(Integer id);

    void insertCustomer(Customer customer);

    boolean existsPersonWithEmail(String email);

    boolean existsPersonWithId(Integer customerId);

    void deleteCustomerById(Integer customerId);

    void updateCustomer(Customer update);

}
