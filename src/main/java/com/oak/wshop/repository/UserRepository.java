package com.oak.wshop.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.oak.wshop.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
