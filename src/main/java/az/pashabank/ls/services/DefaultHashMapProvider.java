package az.pashabank.ls.services;

import az.pashabank.ls.entities.CustomerDto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Profile("default")
public class DefaultHashMapProvider implements HashMapProvider {
    HashMap<Long, CustomerDto> customerHashMap = new HashMap<>(){
        {
            put(1L, CustomerDto.builder().id(1L).name("Cusomer 1").build());
            put(2L, CustomerDto.builder().id(2L).name("Customer 2").build());
        }
    };

    @Override
    public HashMap<Long, CustomerDto> recieveHashMap() {
        return customerHashMap;
    }
}
