package az.pashabank.ls.repository;

import az.pashabank.ls.entities.CustomerDto;
import az.pashabank.ls.entities.CustomerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Repository
@Profile("default")
public class CustomerRepositoryDefault implements CustomerRepository {

    private static final Logger logger = LoggerFactory.getLogger(CustomerRepositoryDev.class);

    Long id;

    HashMap<Long, CustomerEntity> customers = new HashMap<>() {
        {
            put(1L, CustomerEntity.builder().id(1L).firstName("Azer").lastName("Sharifov").build());
            put(2L, CustomerEntity.builder().id(2L).firstName("Orxan").lastName("Mutalibov").build());
        }
    };

    public CustomerRepositoryDefault() {
        id = (long) customers.size();
    }

    public CustomerEntity findById(Long id) {
        logger.info("CustomerRepository.findById(Long id) was called with id = " + id);
        CustomerEntity foundCustomer;
        foundCustomer = customers.get(id);
        if (foundCustomer == null) {
            logger.warn("Customer was not found with id = " + id);
            throw new EntityNotFoundException("Customer not found with id = " + String.valueOf(id));
        }
        return foundCustomer;
    }

    public List<CustomerEntity> findAll() {
        logger.info("CustomerRepository.findAll() was called");
        return customers.values().stream().collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        logger.info("CustomerRepository.deleteById(Long id) was called with id = " + id);
        findById(id);
        customers.remove(id);
    }

    public CustomerEntity save(CustomerEntity customerEntity) {
        logger.info("CustomerRepository.save(CustomerDto c) was called with c.id = " + customerEntity.getId());
        if (customerEntity.getId() != null && (customerEntity.getId() >= id || !customers.containsKey(customerEntity.getId()))) {
            logger.warn("Customer with id = " + customerEntity.getId() + " was not found. Can't be updated");
            throw new NoSuchElementException();
        } else if (customerEntity.getId() == null) {
            customerEntity.setId(++id);
        }
        customers.put(customerEntity.getId(), customerEntity);
        return customerEntity;
    }
}
