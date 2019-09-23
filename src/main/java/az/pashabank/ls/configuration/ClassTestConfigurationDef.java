package az.pashabank.ls.configuration;

import az.pashabank.ls.entities.CustomerDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.HashMap;

@Configuration
@Profile("def")
public class ClassTestConfigurationDef {
    @Bean
    public HashMap<Long, CustomerDto> getCustomerHashMap(){
        return new HashMap<>(){
            {
                put(3L, CustomerDto.builder().id(1L).name("Cusomer 3").build());
                put(4L, CustomerDto.builder().id(2L).name("Customer 4").build());
            }
        };
    }
}
