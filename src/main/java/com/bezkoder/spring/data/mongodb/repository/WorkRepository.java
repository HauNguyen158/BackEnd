package com.bezkoder.spring.data.mongodb.repository;
import com.bezkoder.spring.data.mongodb.model.Work;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface WorkRepository extends MongoRepository<Work, String> {

}
