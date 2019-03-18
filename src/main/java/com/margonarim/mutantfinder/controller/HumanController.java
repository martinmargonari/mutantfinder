package com.margonarim.mutantfinder.controller;

import com.margonarim.mutantfinder.model.Human;
import com.margonarim.mutantfinder.services.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HumanController {

    @Autowired
    private HumanService humanService;

    @PostMapping(value = "/mutant")
    public ResponseEntity post(@RequestBody Map<String,String[]> dna) {

        Human human = new Human(dna.get("dna"));
        humanService.save(human);

        if (human.isMutant()) {
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }
}
