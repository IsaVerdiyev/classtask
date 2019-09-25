package az.pashabank.ls.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

@Service
public class NamesService {
    Random random = new Random(System.currentTimeMillis());

    ArrayList<String> names = new ArrayList<>() {
        {
            add("Orxan");
            add("Xeyal");
            add("Kanan");
            add("Emil");
            add("Ali");
            add("Vali");
        }
    };


    public String getRandomName() {
        return names.get(random.nextInt(names.size()));
    }
}
