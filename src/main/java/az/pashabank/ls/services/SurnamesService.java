package az.pashabank.ls.services;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class SurnamesService {
    Random random = new Random(System.currentTimeMillis());

    ArrayList<String> surnames = new ArrayList<String>(){
        {
            add("Salimov");
            add("Veliyev");
            add("Seyidov");
            add("Haciyev");
            add("Aslanov");
        }
    };

    public String getRandomSurname(){
        return surnames.get(random.nextInt(surnames.size()));
    }
}
