package com.ratanparai.crm.controllers;

import java.util.List;

import com.ratanparai.crm.event.OlcmCreatedEvent;
import com.ratanparai.crm.infrastructure.OlcmRepository;
import com.ratanparai.crm.messaging.CrmChannels;
import com.ratanparai.crm.models.Olcm;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
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
	private CrmChannels crmChannels;

	public OlcmController(OlcmRepository olcmRepository, CrmChannels crmChannels) {
        this.olcmRepository = olcmRepository;
        this.crmChannels = crmChannels;
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
        Olcm savedOlcm = olcmRepository.save(olcm);

        OlcmCreatedEvent event = new OlcmCreatedEvent(savedOlcm);
        crmChannels.olcmCreatedOut().send(MessageBuilder.withPayload(event).build());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}