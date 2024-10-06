package com.example.flightmail.controller;

import com.example.flightmail.dto.FlightMailDto;
import com.example.flightmail.service.FlightMailService;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/flightmail")

public class FlightMailController {
    @Autowired
    private FlightMailService flightMailService;

    @PostMapping("/send")
    public ResponseEntity<FlightMailDto> sendFlightMail(@RequestBody FlightMailDto flightMailDto) {
        try {
            FlightMailDto sentFlightMail = flightMailService.sendFlightMail(flightMailDto);
            return ResponseEntity.ok(sentFlightMail);
        } catch (MessagingException | IOException | TemplateException e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
