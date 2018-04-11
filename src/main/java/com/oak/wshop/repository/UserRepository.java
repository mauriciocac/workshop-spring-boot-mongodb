package com.oak.wshop.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.oak.wshop.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	@Query("{ 'nome': {$regex: ?0, $options: 'i'}}")
	List<User> findByNamesUsers(String nome);

}
