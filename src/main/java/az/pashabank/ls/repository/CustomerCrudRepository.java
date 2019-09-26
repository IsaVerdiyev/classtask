package az.pashabank.ls.repository;

import az.pashabank.ls.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface CustomerCrudRepository extends CrudRepository<CustomerEntity, Long> {
}
