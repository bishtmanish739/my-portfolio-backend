package com.my_porfolio.myportfolio.service;

import com.my_porfolio.myportfolio.domain.Profile;
import com.my_porfolio.myportfolio.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProfileServiceImpl implements ProfileService{
    @Autowired
    ProfileRepository profileRepository;
    @Override
    public Profile saveProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile getProfile(String id) {
        return profileRepository.findById(id).orElse( null);

    }
}
