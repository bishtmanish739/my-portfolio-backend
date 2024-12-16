package com.my_porfolio.myportfolio.service;

import com.my_porfolio.myportfolio.domain.Profile;
import com.my_porfolio.myportfolio.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService{
    @Autowired
    ProfileRepository profileRepository;
    @Override
    public Profile saveProfile(Profile profile) {
        try {
            return  profileRepository.save(profile);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Profile getProfile(String id) {
        return profileRepository.findById(id).orElse( null);

    }

    @Override
    public Profile findById(String id) {
        return profileRepository.findById(id).orElseThrow(()-> new RuntimeException("not found"));
    }

    @Override
    public Profile findByName(String name) {
        return profileRepository.findFirstByName(name).orElseThrow(()-> new RuntimeException("not found"));
    }
}
