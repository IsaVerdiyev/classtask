package az.pashabank.ls.services;

import az.pashabank.ls.entities.CustomerDto;

import java.util.HashMap;

public interface HashMapProvider {
    HashMap<Long, CustomerDto> recieveHashMap();
}
