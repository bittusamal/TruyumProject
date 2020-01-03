package com.cognizant.TruyumAuthentication.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/truyum")

public class AuthenticationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {

		LOGGER.info("Start");
		Map<String, String> data = new HashMap<>();

		data.put("token", generateJwt(getUser(authHeader)));

		String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString();
		Authentication authen = SecurityContextHolder.getContext().getAuthentication();
		String user = authen.getName();

		data.put("role", role);
		data.put("user", user);
		LOGGER.info("End");
		return data;

	}

	private String getUser(String authHeader) {
		LOGGER.info("Start");

		String auth[] = authHeader.split(" ");
		String encodedCredentials = auth[1];
		String decodedCredentials = new String(Base64.getDecoder().decode(encodedCredentials));
		LOGGER.info("End");

		return decodedCredentials.split(":")[0];
	}

	private String generateJwt(String user) {
		LOGGER.info("Start");

		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);
		builder.setIssuedAt(new Date());
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");
		String token = builder.compact();

		LOGGER.info("End");
		return token;
	}

}
