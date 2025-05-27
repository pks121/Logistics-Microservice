package com.example.Feedback.Service.controller;

import com.example.Feedback.Service.dto.FeedbackDto;
import com.example.Feedback.Service.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @PostMapping("/submit")
    public ResponseEntity<Response> submitForm(@RequestBody FeedbackDto feedbackDto){
        feedbackDto.setSubmittedAt(LocalDateTime.now());
        return new ResponseEntity<>(new Response("Form submitted successfully", feedbackDto), HttpStatus.OK);
    }

}
