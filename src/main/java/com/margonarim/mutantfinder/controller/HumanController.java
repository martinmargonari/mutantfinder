package com.margonarim.mutantfinder.controller;

import com.margonarim.mutantfinder.model.Human;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HumanController {

    @PostMapping(value = "/mutant")
    public ResponseEntity post(@RequestBody String[] dna) {
        if (Human.isMutant(dna)) {
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }
}
