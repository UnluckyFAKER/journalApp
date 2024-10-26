package com.moulik.journalApp.repository;

import com.moulik.journalApp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface Userrepo extends MongoRepository <User, String> {
    User findByUsername(String Username);
    User deleteByUsername(String Username);

}

