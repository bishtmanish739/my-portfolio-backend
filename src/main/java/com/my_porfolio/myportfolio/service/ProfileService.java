package com.my_porfolio.myportfolio.service;

import com.my_porfolio.myportfolio.domain.Profile;

public interface ProfileService {
     Profile saveProfile(Profile profile);
     Profile getProfile(String id);

}
