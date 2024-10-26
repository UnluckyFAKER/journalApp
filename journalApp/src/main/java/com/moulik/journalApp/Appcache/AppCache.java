package com.moulik.journalApp.Appcache;

import com.moulik.journalApp.model.Weatherclass;
import com.moulik.journalApp.repository.Weatherrepo;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Slf4j
public class AppCache {
    @Autowired
    private Weatherrepo weatherrepo;

    private Map <String,String> APP_CACHE;

    @PostConstruct
    public void inin(){
        APP_CACHE = new HashMap<>();
        // fetch the data from mongodb to a weatheclass type list all
        List<Weatherclass> all = weatherrepo.findAll();
        if (all.isEmpty()) {
            log.error("No entries found in the database.");
        }

        for (Weatherclass weatherclass : all) {
            // put value to APP_CACHE
            APP_CACHE.put(weatherclass.getKey(),weatherclass.getValue());
        }
    }
    public Map<String, String> getAppCache() {
        return APP_CACHE;
    }
}
