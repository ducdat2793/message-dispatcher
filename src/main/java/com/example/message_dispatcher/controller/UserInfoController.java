package com.example.message_dispatcher.controller;

import java.util.Map;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user-info")
public class UserInfoController {

	@GetMapping()
	public Map<String, Object> getCurrentUser(@AuthenticationPrincipal OAuth2User principal) {
	    return Map.of(
	        "name", principal.getAttribute("name"),
	        "email", principal.getAttribute("email"),
	        "picture", principal.getAttribute("picture")
	    );
	}

	
}
