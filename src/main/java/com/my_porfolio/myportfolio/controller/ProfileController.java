package com.my_porfolio.myportfolio.controller;

import com.my_porfolio.myportfolio.domain.Profile;
import com.my_porfolio.myportfolio.service.ProfileService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/profile")
@CrossOrigin
public class ProfileController {
    @Autowired
    ProfileService profileService;
    @Autowired
    RestTemplate restTemplate;

    Logger log= LoggerFactory.getLogger(ProfileController.class);


    @GetMapping("/{id}")
    ResponseEntity<Profile> getProfileById(@PathVariable String id){
        log.debug("id is:{}",id);
        return ResponseEntity.ok(profileService.getProfile(id));
    }
    @GetMapping("")
    ResponseEntity<Profile> getProfileByName(@RequestParam String name){
        log.debug("name is:{}",name);
        return ResponseEntity.ok(profileService.findByName(name));
    }
    @PostMapping("")
    ResponseEntity<Profile> saveProfile(@RequestBody Profile profile){
        log.debug("Profile Received to save:{}",profile);
        return ResponseEntity.ok(profileService.saveProfile(profile));
    }
    @PutMapping("")
    ResponseEntity<Profile> updateProfile(@RequestBody Profile profile){
        log.debug("Profile Received to save:{}",profile);
        return ResponseEntity.ok(profileService.updateProfile(profile));
    }
    @GetMapping("/test")
    @CircuitBreaker(name = "circuitBreakerTest",fallbackMethod = "circuitBreakerFallbackMethod")
    ResponseEntity<String> circuitBreakerExample(){
        String ans=profileService.testCircuitBreaker();
        return ResponseEntity.ok(ans);
    }
    ResponseEntity<String> circuitBreakerFallbackMethod(Throwable throwable){
        return ResponseEntity.ok("Service is down");
    }


    @GetMapping("/get-leetcode")
    ResponseEntity<Object> leetcodeSubmission(){

       Object object= restTemplate.exchange("https://alfa-leetcode-api.onrender.com/userProfileCalendar?username=bishtmanish739&year=2025", HttpMethod.GET,null, Object.class);
       return  ResponseEntity.ok(object);
    }

}
