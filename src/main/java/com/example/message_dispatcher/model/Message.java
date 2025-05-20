package com.example.message_dispatcher.model;

import java.time.LocalDateTime;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table(name = "message")
@NoArgsConstructor
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String content;
    private LocalDateTime timestamp;
    
    public Message(String content) {
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }
    
}
