package az.pashabank.ls.repository;

import az.pashabank.ls.entities.CustomerDto;
import az.pashabank.ls.entities.CustomerEntity;

import java.util.List;

public interface CustomerRepository {
    public CustomerEntity findById(Long id);
    public List<CustomerEntity> findAll();
    public void deleteById(Long id);
    public CustomerEntity save(CustomerEntity customerEntity);
}
