package com.Developer.Chatbot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final String RASA_URL = "http://localhost:5005/webhooks/rest/webhook"; 

    @PostMapping
    public ResponseEntity<?> chat(@RequestBody String message) {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(RASA_URL, message, String.class);
        return ResponseEntity.ok(response); 
    }
}
