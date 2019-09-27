package az.pashabank.ls.tools;


import az.pashabank.ls.entities.CustomerDto;
import az.pashabank.ls.repository.CustomerRepository;
import az.pashabank.ls.repository.CustomerRepositoryDev;
import az.pashabank.ls.services.CustomerService;
import az.pashabank.ls.services.NamesService;
import az.pashabank.ls.services.SurnamesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SpringConfig {
    private static final Logger logger = LoggerFactory.getLogger(SpringConfig.class);


    private CustomerService customerService;
    private NamesService namesService;
    private SurnamesService surnamesService;

    public SpringConfig(CustomerService customerService,
                        NamesService namesService,
                        SurnamesService surnamesService){
        this.namesService = namesService;
        this.surnamesService = surnamesService;
        this.customerService = customerService;
    }

    @Scheduled(fixedDelay = 20 * 1000)
    public void scheduleAddingCustomer(){
        customerService.addCustomer(CustomerDto.builder()
                .firstName(namesService.getRandomName())
                .lastName(surnamesService.getRandomSurname())
                .build());
    }
}
