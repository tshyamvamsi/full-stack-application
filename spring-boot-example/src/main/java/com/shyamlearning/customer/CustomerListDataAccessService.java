package com.shyamlearning.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CustomerListDataAccessService implements CustomerDAO{

    private static final List<Customer> customers;
    static{
        customers = new ArrayList<>();
        Customer alex =new Customer(
                1,
                "alex",
                "alex@gmail.com",
                21
        );
        Customer peter =new Customer(
                2,
                "peter",
                "peter@gmail.com",
                22
        );

        customers.add(alex);
        customers.add(peter);


    }
    @Override
    public List<Customer> selectAllCustomers() {


        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {

        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }
}
