package com.bezkoder.spring.data.mongodb.controller;

import java.util.List;
import java.util.Optional;

import com.bezkoder.spring.data.mongodb.model.Work;
import com.bezkoder.spring.data.mongodb.repository.WorkRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin()

@RestController
@RequestMapping("/api/work")

public class WorkController {
    @Autowired
    WorkRepository workRepository;

    @GetMapping("/all")
    public ResponseEntity<List<Work>> getAllWork() {

        return new ResponseEntity<>(workRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Work> getWorkByID(@PathVariable("id") String id) {
        try {
            Work _work = workRepository.findById(id).get();

            return new ResponseEntity<>(_work,HttpStatus.OK);
      } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
      }
    }

    @PostMapping("/add")
    public ResponseEntity<Work> addWork(@RequestBody Work work){
        try {
            workRepository.save(work);
            return new ResponseEntity<>(work, HttpStatus.CREATED);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Work> editWork(@PathVariable("id") String id, @RequestBody Work work){
        Optional<Work> workData = workRepository.findById(id);
        try {
            if(workData.isPresent()){
                Work _work = workData.get();
                _work = work;
                _work.setID(id);
                return new ResponseEntity<>(workRepository.save(_work), HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<HttpStatus> delWork(@PathVariable("id") String id){
        try {
                workRepository.deleteById(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/del/all")
    public ResponseEntity<HttpStatus> delAllWork(){
        try {
                workRepository.deleteAll();
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
          } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
