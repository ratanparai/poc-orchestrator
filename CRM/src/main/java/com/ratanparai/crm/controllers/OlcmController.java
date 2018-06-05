package com.ratanparai.crm.controllers;

import java.util.List;

import com.ratanparai.crm.infrastructure.OlcmRepository;
import com.ratanparai.crm.models.Olcm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/olcm")
public class OlcmController {

    private OlcmRepository olcmRepository;

	public OlcmController(OlcmRepository olcmRepository) {
        this.olcmRepository = olcmRepository;
    }

    @GetMapping
    public ResponseEntity<?> getAllOlcm() {
        List<Olcm> allOlcms = olcmRepository.findAll();

        if(allOlcms.size() == 0){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(allOlcms, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createOlcmEntry(@RequestBody Olcm olcm, Model model) {
        olcmRepository.save(olcm);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}