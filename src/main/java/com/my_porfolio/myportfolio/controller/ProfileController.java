package com.my_porfolio.myportfolio.controller;

import com.my_porfolio.myportfolio.domain.Profile;
import com.my_porfolio.myportfolio.service.ProfileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    Logger log= LoggerFactory.getLogger(ProfileController.class);


    @GetMapping("/{id}")
    ResponseEntity<Profile> getProfileById(@PathVariable String id){
        log.debug("id is:{}",id);
        return ResponseEntity.ok(null);
    }
    @PostMapping("")
    ResponseEntity<Profile> saveProfile(@RequestBody Profile profile){
        log.debug("Profile Received to save:{}",profile);
        return ResponseEntity.ok(profileService.saveProfile(profile));
    }
}
