package com.moulik.journalApp.controler;


import com.moulik.journalApp.apiresponse.WeatherApi;
import com.moulik.journalApp.model.User;
import com.moulik.journalApp.repository.Userrepo;
import com.moulik.journalApp.service.ExternalApiService;
import com.moulik.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

import java.util.Optional;
//@Autowired
//private AuthenticationManager authenticationManager;

@RestController
@RequestMapping("/user")

public class Usertest {
  @Autowired
  private UserService userservices;

  @Autowired
  Userrepo ur;
  @Autowired
  ExternalApiService  externalApiService;




  @DeleteMapping
  public ResponseEntity<?> deletebyid() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    ur.deleteByUsername(authentication.getName());
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);

  }

  @GetMapping("/id/{myid}")
  public ResponseEntity<User> getbyid(@PathVariable String myid) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    Optional<User> Userentry = userservices.findbyid(myid);
    if (Userentry.isPresent()) {
      return new ResponseEntity<User>(Userentry.get(), HttpStatus.ACCEPTED);

    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);

  }

  @PutMapping
  public ResponseEntity<?> updateUser(@RequestBody User user) {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String userName = authentication.getName();
    User userInDb = userservices.findByUsername(userName);
    userInDb.setUsername(user.getUsername());
    userInDb.setPassword(user.getPassword());
    userservices.saveentryUser(userInDb);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
  @GetMapping("/weather")
  public ResponseEntity<?> cityweather(){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    // assing the body we got from service class to a new pojo object
    WeatherApi weatherApi = externalApiService.getweather("Kolkata");
    String wellcome="";
    if(weatherApi!=null){
      wellcome=" weather feels like  "+weatherApi.getCurrent().getFeelslike();
    }

    return new ResponseEntity<>("hi "+authentication.getName()+wellcome,HttpStatus.OK);


  }

}