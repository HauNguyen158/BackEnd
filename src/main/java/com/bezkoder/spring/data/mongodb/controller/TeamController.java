package com.bezkoder.spring.data.mongodb.controller;
import java.util.List;

import com.bezkoder.spring.data.mongodb.model.Team;
import com.bezkoder.spring.data.mongodb.repository.TeamRepositor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()

@RestController
@RequestMapping("/api/team")

public class TeamController {
    @Autowired
    TeamRepositor teamRepository;
    
    @GetMapping("/all")
    public ResponseEntity<List<Team>> getAllTeam() {

        return new ResponseEntity<>(teamRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Team> getWorkByID(@PathVariable("id") String id) {
        try {
            Team _team = teamRepository.findById(id).get();

            return new ResponseEntity<>(_team,HttpStatus.OK);
      } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

}
