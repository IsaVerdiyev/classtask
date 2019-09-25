package az.pashabank.ls.controllers;

import az.pashabank.ls.entities.CustomerDto;
import az.pashabank.ls.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<CustomerDto> get(@PathVariable("id") Long id){
        logger.info("CustomerController.get(Long id) was called with id = " + id);
        return new ResponseEntity<>(customerService.recieveCustomerById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CustomerDto> post(@Valid @RequestBody CustomerDto customerDto){
        logger.info("CustomerController.post(CustomerDto c) was called with c.id = " + customerDto.getId());
        return new ResponseEntity<>(customerService.addCustomer(customerDto), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<CustomerDto> put(@Valid @RequestBody CustomerDto customerDto){
        logger.info("CustomerController.put(CustomerDto c) was called with c.id = " + customerDto.getId());
        return new ResponseEntity<>(customerService.updateCustomer(customerDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        logger.info("CustomerController.delete(Long id) was called id = " + id);
        customerService.deleteCustomer(id);
    }
}
