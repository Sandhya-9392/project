package com.cricket.cricket.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.cricket.cricket.model.Cricket;
import com.cricket.cricket.repository.CricketRepository;

@RestController
@RequestMapping("/api")
public class CricketController {
    @Autowired
    CricketRepository cricketRepository;

    @GetMapping("/crickets")
    public ResponseEntity<List<Cricket>> getAllcrickets(@RequestParam(required = false) String teamname) {

        List<Cricket> crickets = new ArrayList<Cricket>();

        cricketRepository.findAll().forEach(crickets::add);

        return new ResponseEntity<>(crickets, HttpStatus.OK);

    }

    @PostMapping("/crickets/{id}")
    public ResponseEntity<Cricket> createCricket(@RequestBody Cricket cricket) {
        Cricket _cricket = cricketRepository
        .save(new Cricket(cricket.geteamname(), cricket.geteammembers(), cricket.gettotalmatches(), cricket.getwon(), cricket.getloss(), cricket.getrunrate()));
        return new ResponseEntity<Cricket>(_cricket, HttpStatus.CREATED);
    }

    @PutMapping("/crickets/{id}")
    public ResponseEntity<Cricket> updateCricket(@PathVariable("id") long id, @RequestBody Cricket cricket) {
        Optional<Cricket> cricketData = cricketRepository.findById(id);

        Cricket _cricket = cricketData.get();
        _cricket.setteammembers(cricket.geteamname());
        _cricket.setteammembers(cricket.geteammembers());
        _cricket.settotalmatches(cricket.gettotalmatches());
        _cricket.setwon(cricket.getwon());
        _cricket.setloss(cricket.getloss());
        _cricket.setrunrate(cricket.getrunrate());
        return new ResponseEntity<>(cricketRepository.save(_cricket), HttpStatus.OK);

    }

    @DeleteMapping("/crickets/{id}")
    public ResponseEntity<HttpStatus> deleteCricket(@PathVariable("id") long id) {
        try {
             cricketRepository.deleteById(id);
             return new ResponseEntity<>(HttpStatus.NO_CONTENT );

        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }

    @DeleteMapping("/crickets")
    public ResponseEntity<HttpStatus> deleteAllCricket() {
        try {
            cricketRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
