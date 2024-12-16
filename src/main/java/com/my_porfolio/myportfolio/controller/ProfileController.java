package com.my_porfolio.myportfolio.controller;

import com.my_porfolio.myportfolio.domain.Profile;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
;

@RestController
@RequestMapping("/profile")
public class ProfileController {


    @GetMapping("/{id}")
    ResponseEntity<Profile> getProfileById(@PathVariable String id){
        System.out.println("id is:"+id);
        return ResponseEntity.ok(null);
    }
}
