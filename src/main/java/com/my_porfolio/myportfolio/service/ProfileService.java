package com.my_porfolio.myportfolio.service;

import com.my_porfolio.myportfolio.domain.Profile;

public interface ProfileService {
     Profile saveProfile(Profile profile);
     Profile getProfile(String id);

     Profile findById(String id);

     Profile findByName(String name);

     Profile updateProfile(Profile profile);

     String testCircuitBreaker();
}
