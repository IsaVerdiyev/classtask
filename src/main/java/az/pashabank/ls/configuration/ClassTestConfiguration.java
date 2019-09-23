package az.pashabank.ls.configuration;


import az.pashabank.ls.entities.CustomerDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

@Configuration
public class ClassTestConfiguration {

    @Bean
    public HashMap<Long, CustomerDto> getCustomerHashMap(){
        return new HashMap<>(){
            {
                put(1L, CustomerDto.builder().id(1L).name("Cusomer 1").build());
                put(2L, CustomerDto.builder().id(2L).name("Customer 2").build());
            }
        };
    }
}
