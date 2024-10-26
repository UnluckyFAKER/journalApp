package com.moulik.journalApp.repository;

import com.moulik.journalApp.model.Weatherclass;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Weatherrepo extends MongoRepository<Weatherclass, String> {
}
