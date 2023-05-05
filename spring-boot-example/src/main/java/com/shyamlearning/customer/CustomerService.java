package com.shyamlearning.customer;

import com.shyamlearning.exception.DuplicateResouceException;
import com.shyamlearning.exception.RequestValidationException;
import com.shyamlearning.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerService(@Qualifier("jpa") CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }


    public List<Customer> getAllCustomers(){
        return customerDAO.selectAllCustomers();
    }

    public Customer getCustomer(Integer id){
        return customerDAO.selectCustomerById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Customer with id %s not present.".formatted(id))
                );
    }

    public void addCustomer(CustomerRegistrationRequest customer) {
         // check if email exists
        String email = customer.email();
        if(customerDAO.existsPersonWithEmail(email))
            throw new DuplicateResouceException(
                    "Customer already present"
            );
        // else add
        customerDAO.insertCustomer(
                    new Customer(
                            customer.name(),
                            customer.email(),
                            customer.age()
                    )
            );
    }

    public void deleteCustomerByID(Integer customerId){
        if(! customerDAO.existsPersonWithId(customerId)){
            throw new ResourceNotFoundException("Customer with id %s not present.".formatted(customerId));
        }

        customerDAO.deleteCustomerById(customerId);
    }

    public void updateCustomer(Integer id,
                               CustomerRegistrationRequest updateRequest){
        Customer customer = getCustomer(id);

        boolean changes = false;

        if (updateRequest.name() != null && !updateRequest.name().equals(customer.getName())) {
            customer.setName(updateRequest.name());
            changes = true;
        }
        if (updateRequest.age() != null && !updateRequest.age().equals(customer.getAge())) {
            customer.setAge(updateRequest.age());
            changes = true;
        }
        if (updateRequest.email() != null && !updateRequest.email().equals(customer.getEmail())) {
            if (customerDAO.existsPersonWithEmail(updateRequest.email())) {
                throw new DuplicateResouceException(
                        "email already taken"
                );
            }
            customer.setEmail(updateRequest.email());
            changes = true;
        }
        if (!changes) {
            throw new RequestValidationException("no data changes found");
        }

        customerDAO.updateCustomer(customer);

    }
}
