package com.codeclan.example.pirateservice.controllers;

import com.codeclan.example.pirateservice.models.Pirate;
import com.codeclan.example.pirateservice.models.Raid;
import com.codeclan.example.pirateservice.repositories.PirateRepository;
import com.codeclan.example.pirateservice.repositories.RaidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PirateController {

    @Autowired
    PirateRepository pirateRepository;

    @Autowired
    RaidRepository raidRepository;

    @GetMapping(value = "/pirates")
    public List<Pirate> getAllPirates(){
        return pirateRepository.findAll();
    }

    @GetMapping(value = "/pirates/{id}")
    public Optional<Pirate> getPirateById(@PathVariable Long id){
        return  pirateRepository.findById(id);
    }

    @GetMapping(value = "/pirates/{id}/raids")
    public List<Raid> getAllRaidsOfPirate(@PathVariable Long id){
        Optional <Pirate> pirate = pirateRepository.findById(id);
        return  pirate.get().getRaids();
    }
}
