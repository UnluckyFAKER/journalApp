package com.moulik.journalApp.repository;

import com.moulik.journalApp.model.Journalentry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface journalRepo  extends MongoRepository <Journalentry, String> {

}
