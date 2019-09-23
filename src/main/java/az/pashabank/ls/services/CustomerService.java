package az.pashabank.ls.services;

import az.pashabank.ls.entities.CustomerDto;
import az.pashabank.ls.repository.CustomerRepository;
import az.pashabank.ls.repository.CustomerRepositoryDef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    CustomerRepository customerRepositoryDef;

    public CustomerService(CustomerRepositoryDef customerRepositoryDef){
        this.customerRepositoryDef = customerRepositoryDef;
    }

    public CustomerDto recieveCustomerById(Long Id){
        logger.info("CustomerService.recieveCustomerById was called with " + Id + " parameter");
        return customerRepositoryDef.findById(Id);
    }

    public List<CustomerDto> recieveAllCustomers(){
        logger.info("CustomerService.recieveAllCustomers was called");
        return customerRepositoryDef.findAll();
    }

    public CustomerDto addCustomer(CustomerDto customerDto){
        logger.info("CustomerService.addCustomer was called with customer id = " + customerDto.getId());
        return customerRepositoryDef.save(customerDto);
    }

    public void deleteCustomer(Long id){
        logger.info("CustomerService.deleteCustomer was called with " + id);
        customerRepositoryDef.deleteById(id);
    }

}
