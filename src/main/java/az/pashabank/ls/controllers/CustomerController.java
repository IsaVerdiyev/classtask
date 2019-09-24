package az.pashabank.ls.controllers;

import az.pashabank.ls.entities.CustomerDto;
import az.pashabank.ls.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    CustomerService customerService;

    @GetMapping
    public List<CustomerDto> get(){
        logger.info("CustomerController.get() was called");
        return customerService.recieveAllCustomers();
    }

    @GetMapping("/{id}")
    public CustomerDto get(@PathVariable("id") Long id){
        logger.info("CustomerController.get(Long id) was called with id = " + id);
        return customerService.recieveCustomerById(id);
    }

    @PostMapping
    public CustomerDto post(@RequestBody CustomerDto customerDto){
        logger.info("CustomerController.post(CustomerDto c) was called with c.id = " + customerDto.getId());
        return customerService.addCustomer(customerDto);
    }

    @PutMapping
    public CustomerDto put(@RequestBody CustomerDto customerDto){
        logger.info("CustomerController.put(CustomerDto c) was called with c.id = " + customerDto.getId());
        return customerService.updateCustomer(customerDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        logger.info("CustomerController.delete(Long id) was called id = " + id);
        customerService.deleteCustomer(id);
    }
}
