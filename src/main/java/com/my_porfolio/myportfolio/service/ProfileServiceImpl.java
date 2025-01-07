package com.my_porfolio.myportfolio.service;

import com.my_porfolio.myportfolio.domain.Profile;
import com.my_porfolio.myportfolio.repository.ProfileRepository;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService{
    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    RedisService redisService;
    @Override
    public Profile saveProfile(Profile profile) {
        try {
            Profile p=  profileRepository.save(profile);
            redisService.setValue(profile.getId(),p,20000L);
            return p;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Profile getProfile(String id) {
       Profile p= redisService.getValue(id,Profile.class);
       if(p!=null){
           return  p;
       }
        p= profileRepository.findById(id).orElse( null);
        if(p!=null){
            redisService.setValue(p.getId(),p,2000L);

        }

        return p;


    }

    @Override
    public Profile findById(String id) {
        return profileRepository.findById(id).orElseThrow(()-> new RuntimeException("not found"));
    }

    @Override
    public Profile findByName(String name) {
        return profileRepository.findFirstByName(name).orElseThrow(()-> new RuntimeException("not found"));
    }

    @Override
    public Profile updateProfile(Profile profile) {
        try {
            String id=profile.getId();
            Profile savedProfile=getProfile(id);
            if(savedProfile==null){
                throw new BadRequestException("Profile not found");
            }
            Profile p=  profileRepository.save(profile);
            redisService.setValue(profile.getId(),p,20000L);
            return p;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String testCircuitBreaker() {

        return String.valueOf(1/0);
    }
}
