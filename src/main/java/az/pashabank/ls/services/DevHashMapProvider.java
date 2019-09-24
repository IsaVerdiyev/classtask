package az.pashabank.ls.services;

import az.pashabank.ls.entities.CustomerDto;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Profile("dev")
public class DevHashMapProvider implements HashMapProvider{
    HashMap<Long, CustomerDto> customerHashMap = new HashMap<>(){
        {
            put(1L, CustomerDto.builder().id(1L).name("Mock Customer 1").build());
            put(2L, CustomerDto.builder().id(2L).name("Mock Customer 2").build());
        }
    };

    @Override
    public HashMap<Long, CustomerDto> recieveHashMap() {
        return customerHashMap;
    }
}
