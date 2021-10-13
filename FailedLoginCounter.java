package com.company;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FailedLoginCounter {
    private static FailedLoginCounter instance;
    private Map<String, Integer> wrong = new HashMap<>() {
    };

    public static synchronized FailedLoginCounter getInstance(){
        if (instance == null){
            instance = new FailedLoginCounter();
        }
        return instance;
    }

    public void increaseCount(String email) throws IOException {
        if (wrong.containsKey(email)){
            int number = wrong.get(email);
            wrong.replace(email, number+1);
            if(wrong.get(email) == 5){
                FileService ii = new FileService();
                ii.block(email);
            }
        }else{
            wrong.put(email, 1);
        }
    }
}