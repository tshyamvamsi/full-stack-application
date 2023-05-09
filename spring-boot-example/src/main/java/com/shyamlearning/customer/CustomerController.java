package com.shyamlearning.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {


    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(
            @PathVariable("customerId") Integer customerId){

        return customerService.getCustomer(customerId);
    }

    @PostMapping
    public void registerCustomer (
            @RequestBody CustomerRegistrationRequest req) {
        customerService.addCustomer(req);
    }

    @DeleteMapping("/{customerId}")
    public void deleteCustomer(
            @PathVariable Integer customerId) {

        customerService.deleteCustomerByID(customerId);
    }

    @PutMapping("/{customerId}")
    public void updateCustomer(
            @PathVariable Integer customerId,
            @RequestBody CustomerUpdateRequest  updateRequest
            ) {

        customerService.updateCustomer(customerId, updateRequest );
    }
}
