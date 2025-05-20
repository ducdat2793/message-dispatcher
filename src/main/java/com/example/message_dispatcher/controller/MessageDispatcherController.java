package com.example.message_dispatcher.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.message_dispatcher.service.MessageDispatcher;

@RestController
@RequestMapping("/api/msg-dispatcher")
public class MessageDispatcherController {

	 private final MessageDispatcher dispatcher;

	    public MessageDispatcherController(MessageDispatcher dispatcher) {
	        this.dispatcher = dispatcher;
	    }

	    @PostMapping
	    public ResponseEntity<String> sendMessage(@RequestParam String content) {
	        dispatcher.processAsync(content);
	        return ResponseEntity.ok("Message received: " + content);
	    }
	    
}
