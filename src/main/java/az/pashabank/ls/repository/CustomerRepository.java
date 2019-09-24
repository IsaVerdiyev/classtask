package az.pashabank.ls.repository;

import az.pashabank.ls.entities.CustomerDto;

import java.util.List;

public interface CustomerRepository {
    public CustomerDto findById(Long id);
    public List<CustomerDto> findAll();
    public void deleteById(Long id);
    public CustomerDto save(CustomerDto customerDto);
}
