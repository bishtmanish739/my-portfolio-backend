package com.my_porfolio.myportfolio.repository;


import com.my_porfolio.myportfolio.domain.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProfileRepository extends MongoRepository<Profile,String> {
}
