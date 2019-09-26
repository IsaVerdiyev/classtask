package az.pashabank.ls.repository;

import az.pashabank.ls.entities.CustomerEntity;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Primary
@Repository
public class CustomerRepositoryDb implements CustomerRepository {


    private CustomerCrudRepository customerCrudRepository;

    public CustomerRepositoryDb(CustomerCrudRepository customerCrudRepository){

        this.customerCrudRepository = customerCrudRepository;
    }

    @Override
    public CustomerEntity findById(Long id) {
        return customerCrudRepository.findById(id).get();
    }

    @Override
    public List<CustomerEntity> findAll() {
        List<CustomerEntity> customers = new ArrayList<>();
        customerCrudRepository.findAll().forEach(customers::add);
        return customers;
    }

    @Override
    public void deleteById(Long id) {
        customerCrudRepository.deleteById(id);
    }

    @Override
    public CustomerEntity save(CustomerEntity customerEntity) {
        return customerCrudRepository.save(customerEntity);
    }
}
