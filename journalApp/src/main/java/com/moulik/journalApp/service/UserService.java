package com.moulik.journalApp.service;

import com.moulik.journalApp.model.User;
import com.moulik.journalApp.repository.Userrepo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {
        @Autowired
        private Userrepo UR;
        // you dont need this after adding @Slf4j anno
//    Logger logger = org.slf4j.LoggerFactory.getLogger(JournalService.class);
    // password must be final and static here we set a instance
    public static final PasswordEncoder passEncoder= new BCryptPasswordEncoder();
        public void saveentry(User id){
            UR.save(id);

        }
       public void saveentryUser(User user){
            // Here the password set in hashstring
           //String encode = passEncoder.encode(user.getPassword());
           try {
               user.setPassword(passEncoder.encode(user.getPassword()));
               user.setRoles(Arrays.asList("USER"));
               UR.save(user);
           }
           catch (Exception e){
//               logger.info("Good Work");
//               logger.error("Same user");
//               logger.warn("Same user");
//               logger.debug("Same user");
//               logger.trace("Same user");
               // for Slf4j
               log.info("Good Work");
               log.debug("Same user");
               log.error("Same user");
               log.warn("Same user");
               log.trace("Same user");
               throw new RuntimeException("Same user",e);
           }

    }
        public List<User> getAll(){
            return UR.findAll();
        }
        public Optional<User> findbyid(String myid){
            return UR.findById(myid);
        }
        public void deletebyId(String myid) {
            UR.deleteById(myid);
        }
        public User findByUsername(String username){
            return UR.findByUsername(username);
        }
    public void saveentradmin(User user){
        // Here the password set in hashstring
        //String encode = passEncoder.encode(user.getPassword());
        user.setPassword(passEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER","ADMIN"));
        UR.save(user);

    }

    }

