package com.axpe.exercices.presentation.controllers.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.axpe.exercices.presentation.controllers.EmailController;
import com.axpe.exercices.service.EmailService;

@Controller
public class EmailControllerImpl implements EmailController {

	@Autowired
	private EmailService emailService;

	@Override
	public ResponseEntity<?> validateEmail(UUID xRequestID, String email) {

		boolean isValid = emailService.validateEmail(email);

		if (isValid) {
			return ResponseEntity.ok(HttpStatus.OK);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

}
