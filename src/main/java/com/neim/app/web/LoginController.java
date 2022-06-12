package com.neim.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.neim.app.domain.AccountCredentials;
import com.neim.app.service.JwtService;

@RestController
public class LoginController {
	
	// Used to generate a signed JWT
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	AuthenticationManager authManager;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> getToken(@RequestBody AccountCredentials credentials) {
		// Generate token and send it in Response Authorization Header
		UsernamePasswordAuthenticationToken creds = new UsernamePasswordAuthenticationToken(
				credentials.getUsername(), credentials.getPassword());
		
		Authentication auth = authManager.authenticate(creds);
		
		String jwts = jwtService.getToken(auth.getName());
		
		// Build response with token
		return ResponseEntity.ok()
				.header(HttpHeaders.AUTHORIZATION, "Bearer " + jwts)
				.header(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "Authorization")
				.build();
	}
	
}
