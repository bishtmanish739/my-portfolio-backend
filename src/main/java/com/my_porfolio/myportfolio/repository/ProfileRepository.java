package com.my_porfolio.myportfolio.repository;


import com.my_porfolio.myportfolio.domain.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProfileRepository extends MongoRepository<Profile,String> {
    Optional<Profile> findByName(String name);

    Optional<Profile> findFirstByName(String name);
}
