package com.example.tamingthymeleaf3;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDB {

    public Map<String,String> getUserDB(){
        Map<String, String> mapUserIdToName = new HashMap<>();
        mapUserIdToName.put("1", "AE");
        mapUserIdToName.put("2", "Bohr");
        mapUserIdToName.put("3", "Maxwell");
        return mapUserIdToName;
    }

}
