package com.example.flightmail.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.flightmail.dto.FlightMailDto;
import com.example.flightmail.entity.FlightMail;
import com.example.flightmail.mapper.FlightMailMapper;
import com.example.flightmail.repository.FlightMailRepository;
import freemarker.template.Configuration;
import freemarker.template.Template;

import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.Map;


@Service
public class FlightMailService {
    @Autowired
    private FlightMailRepository flightMailRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private Configuration freemarkerConfig;

    @Autowired
    private FlightMailMapper flightMailMapper; // Autowired mapper, no need to instantiate manually

    public FlightMailDto sendFlightMail(FlightMailDto flightMailDto) throws MessagingException, IOException, TemplateException {
        // Convert DTO to Entity using injected mapper
        FlightMail flightMail = flightMailMapper.toEntity(flightMailDto);
        flightMail.setSendDateTime(LocalDateTime.now());

        // Save flight mail to the repository
        flightMail = flightMailRepository.save(flightMail);

        // Prepare email content using FreeMarker template
        Map<String, Object> model = new HashMap<>();
        model.put("passengerName", flightMailDto.getPassengerName());
        model.put("passengerEmail", flightMailDto.getPassengerEmail());
        model.put("bookingReference", flightMailDto.getBookingReference());
        model.put("currentDateTime", LocalDateTime.now());

        // Load and process the template
        Template template = freemarkerConfig.getTemplate("mail-template.ftl");
        String htmlContent = FreeMarkerTemplateUtils.processTemplateIntoString(template, model); // Fix the definition of htmlContent

        // Send the email
        sendEmail(flightMailDto.getPassengerEmail(), htmlContent);

        // Convert entity back to DTO
        return flightMailMapper.toDto(flightMail);
    }

    private void sendEmail(String to, String htmlContent) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        helper.setTo(to);
        helper.setSubject("Web Booking eTicket");
        helper.setFrom("pallunimbal009@gmail.com");
        helper.setText(htmlContent, true);
        mailSender.send(message);
    }
}
