package com.example.message_dispatcher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.message_dispatcher.service.MessageDispatcher;

@RestController
@RequestMapping("/api/test-jmeter")
public class TestController {

	@Autowired
	private MessageDispatcher dispatcher;

	@PostMapping("/async")
	public ResponseEntity<String> sendMessage1(@RequestParam String content) {
		long start = System.currentTimeMillis();
		dispatcher.processAsync(content);
		long end = System.currentTimeMillis();
		System.out.println("Async call took: " + (end - start) + "ms");
		return ResponseEntity.ok("Message received: " + content);
	}

	@PostMapping("/sync")
	public ResponseEntity<String> sendMessage2(@RequestParam String content) {
		long start = System.currentTimeMillis();
		dispatcher.processSync(content);
		long end = System.currentTimeMillis();
		System.out.println("Sync call took: " + (end - start) + "ms");
		
//		
//		try {
//            Thread.sleep(1000); // mô phỏng xử lý nặng
//        } catch (InterruptedException e) {
//            Thread.currentThread().interrupt();
//        }
		return ResponseEntity.ok("Message received: " + content);
	}

}
