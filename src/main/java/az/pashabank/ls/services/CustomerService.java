package az.pashabank.ls.services;

import az.pashabank.ls.entities.CustomerDto;
import az.pashabank.ls.repository.CustomerRepository;
import az.pashabank.ls.repository.CustomerRepositoryDev;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
public class CustomerService {

    private static final Logger logger = LoggerFactory.getLogger(CustomerService.class);

    @Autowired
    CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    public CustomerDto recieveCustomerById(Long Id){
        logger.info("CustomerService.recieveCustomerById(Long id) was called with id = " + Id);
        return customerRepository.findById(Id);
    }

    public List<CustomerDto> recieveAllCustomers(){
        logger.info("CustomerService.recieveAllCustomers() was called");
        return customerRepository.findAll();
    }

    public CustomerDto addCustomer(CustomerDto customerDto){
        logger.info("CustomerService.addCustomer(CustomerDto c) was called with customer c.id = " + customerDto.getId());
        try {
            recieveCustomerById(customerDto.getId());
        }catch(EntityNotFoundException | JpaObjectRetrievalFailureException ex){}
        return customerRepository.save(customerDto);
    }

    public CustomerDto updateCustomer(CustomerDto customerDto){
        logger.info("CustomerService.updateCustomer(CustomerDto c) was called with c.id = " + customerDto);
        CustomerDto foundCustomer = recieveCustomerById(customerDto.getId());
        if(foundCustomer == null){
            throw new EntityNotFoundException();
        }
        return customerRepository.save(customerDto);
    }

    public void deleteCustomer(Long id){
        logger.info("CustomerService.deleteCustomer(Long id) was called with id = " + id);
        customerRepository.deleteById(id);
    }

}
