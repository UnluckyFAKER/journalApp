package com.moulik.journalApp.service;

import com.moulik.journalApp.Appcache.AppCache;
import com.moulik.journalApp.apiresponse.WeatherApi;
import com.moulik.journalApp.model.User;
import org.apache.catalina.webresources.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ExternalApiService {
    @Value("${weather.api.key}")
    private String apikey;
    @Autowired
    private AppCache appCache;
   @Autowired
    private RestTemplate restTemplate;
   // for GET
   public WeatherApi getweather(String city) {
       // Get the API template from cache using a key (ensure this key exists in APP_CACHE)
       String apiTemplate = appCache.getAppCache().get("Weather_Api");

       if (apiTemplate == null) {
           // Log the issue and throw a custom exception or handle the error gracefully
           throw new RuntimeException("API template not found in the cache for key: <API_TEMPLATE>");
       }

       // Replace the placeholders with the actual values
       String finalapi = apiTemplate.replace("<API_KEY>", apikey).replace("<CITY>", city);

       // Make the API call
       ResponseEntity<WeatherApi> response = restTemplate.exchange(finalapi, HttpMethod.GET, null, WeatherApi.class);

       // Get and return the body
       WeatherApi body = response.getBody();
       return body;
   }

   // for POST but it not working now wetherapi is an external api and doesnot have the info
   public WeatherApi postweather(String city){
       // here we replace the apikey and city
       String finalapi = appCache.getAppCache().get("Weather_Api").replace("<API_KEY>", apikey).replace("<CITY>", city);
       // define the body
       String reqbody ="{\n"+
            " username\":\"Hatu\"," +
               "\n" + " \"password\":\"Hatu\" " +
               "}";
       // set ass http entity
       HttpEntity<String> httpEntity = new HttpEntity<>(reqbody);
       // iinject the body using restTamplate
       ResponseEntity<WeatherApi> response =restTemplate.exchange(finalapi, HttpMethod.POST,httpEntity, WeatherApi.class);
     return null;

   }


}
