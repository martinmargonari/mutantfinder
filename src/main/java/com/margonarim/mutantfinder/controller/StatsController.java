package com.margonarim.mutantfinder.controller;

import com.margonarim.mutantfinder.model.Stats;
import com.margonarim.mutantfinder.services.HumanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatsController {

    @Autowired
    HumanService humanService;

    @GetMapping(value = "/stats", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Stats getStats() {
        return humanService.getStats();
    }
}
