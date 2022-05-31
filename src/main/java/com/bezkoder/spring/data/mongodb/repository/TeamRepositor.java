package com.bezkoder.spring.data.mongodb.repository;
import com.bezkoder.spring.data.mongodb.model.Team;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeamRepositor extends MongoRepository<Team, String> {

}
