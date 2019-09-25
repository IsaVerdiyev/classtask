package az.pashabank.ls.repository;

import az.pashabank.ls.entities.CustomerDto;
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

    HashMap<Long, CustomerDto> customers = new HashMap<>() {
        {
            put(1L, CustomerDto.builder().id(1L).firstName("Azer").lastName("Sharifov").build());
            put(2L, CustomerDto.builder().id(2L).firstName("Orxan").lastName("Mutalibov").build());
        }
    };

    public CustomerRepositoryDefault() {
        id = (long) customers.size();
    }

    public CustomerDto findById(Long id) {
        logger.info("CustomerRepository.findById(Long id) was called with id = " + id);
        CustomerDto foundCustomer;
        foundCustomer = customers.get(id);
        if (foundCustomer == null) {
            logger.warn("Customer was not found with id = " + id);
            throw new EntityNotFoundException("Customer not found with id = " + String.valueOf(id));
        }
        return foundCustomer;
    }

    public List<CustomerDto> findAll() {
        logger.info("CustomerRepository.findAll() was called");
        return customers.values().stream().collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        logger.info("CustomerRepository.deleteById(Long id) was called with id = " + id);
        findById(id);
        customers.remove(id);
    }

    public CustomerDto save(CustomerDto customerDto) {
        logger.info("CustomerRepository.save(CustomerDto c) was called with c.id = " + customerDto.getId());
        if (customerDto.getId() != null && (customerDto.getId() >= id || !customers.containsKey(customerDto.getId()))) {
            logger.warn("Customer with id = " + customerDto.getId() + " was not found. Can't be updated");
            throw new NoSuchElementException();
        } else if (customerDto.getId() == null) {
            customerDto.setId(++id);
        }
        customers.put(customerDto.getId(), customerDto);
        return customerDto;
    }
}
