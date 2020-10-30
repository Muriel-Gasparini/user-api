package com.user.api.mongo.DAO;

import com.user.api.mongo.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Integer> {
}
