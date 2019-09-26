package az.pashabank.ls.services;

import az.pashabank.ls.entities.CustomerDto;
import az.pashabank.ls.entities.CustomerEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerDtoEntityMapper {
    CustomerEntity getEntityFromDto(CustomerDto customerDto){
        return CustomerEntity.builder()
                .id(customerDto.getId())
                .firstName(customerDto.getFirstName())
                .lastName(customerDto.getLastName())
                .build();
    }

    CustomerDto getDtoFromEntity(CustomerEntity customerEntity){
        return CustomerDto.builder()
                .id(customerEntity.getId())
                .firstName(customerEntity.getFirstName())
                .lastName(customerEntity.getLastName())
                .build();
    }
}
