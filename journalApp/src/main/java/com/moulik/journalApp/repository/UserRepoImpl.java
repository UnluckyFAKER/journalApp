package com.moulik.journalApp.repository;

import com.moulik.journalApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserRepoImpl {
    @Autowired
    MongoTemplate mongoTemplate;

//    public List<User> getuser(){
////        User us = mongoTemplate.findById("moulik", User.class);
//        Query query = new Query();
//        query.addCriteria(Criteria.where("username").is("Moulik"));
//        // not equal to
//        query.addCriteria(Criteria.where("username").ne("Moulik"));
//        // less than
//        query.addCriteria(Criteria.where("username").lt("Moulik"));
//        //less than Equals to
//        query.addCriteria(Criteria.where("username").lte("Moulik"));
//        List<User> us2= mongoTemplate.find(query, User.class);
//        return us2;
//    }
public List<User> getSA() {
    Query query = new Query();

    // Match email pattern
    query.addCriteria(Criteria.where("email").regex("^[a-zA-Z0-9._%+-]+@gmail\\.com$"));

    // Check if "SA" is true
    query.addCriteria(Criteria.where("SA").is(true));
    // for excluding someone
    query.addCriteria(Criteria.where("username").nin("Moulik"));

    List<User> users = mongoTemplate.find(query, User.class);
    return users;
}

}
