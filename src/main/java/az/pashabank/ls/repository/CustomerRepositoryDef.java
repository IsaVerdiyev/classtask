package az.pashabank.ls.repository;

import az.pashabank.ls.entities.CustomerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CustomerRepositoryDef {
    private static final Logger logger = LoggerFactory.getLogger(CustomerRepositoryDef.class);


    @Autowired
    HashMap<Long, CustomerDto> customers;

    public CustomerRepositoryDef(HashMap<Long, CustomerDto> customers){

        this.customers = customers;
    }

    public CustomerDto findById(Long id){
        logger.info("CustomerRepository.findById(Long id) was called with id = " + id);
        return customers.get(id);
    }

    public List<CustomerDto> findAll(){
        logger.info("CustomerRepository.findAll() was called");
        return customers.values().stream().collect(Collectors.toList());
    }

    public void deleteById(Long id){
        CustomerDto customerDto = findById(id);
        logger.info("CustomerRepository.deleteById(Long id) was called with id = " + id);
        if(customerDto == null){
            logger.warn("Coudn't delete customerDto with parameter id. Was not found");
            throw  new EntityNotFoundException();
        }

        customers.remove(id);
    }

    public CustomerDto save(CustomerDto customerDto){
        logger.info("CustomerRepository.save(CustomerDto c) was called with c.id = " + customerDto.getId());
        return customers.put(customerDto.getId(), customerDto);
    }
}
