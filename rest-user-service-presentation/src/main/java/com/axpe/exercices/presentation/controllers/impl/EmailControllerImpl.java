package com.axpe.exercices.presentation.controllers.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.axpe.exercices.presentation.controllers.EmailController;
import com.axpe.exercices.service.EmailService;
import com.axpe.exercices.service.dto.EmailDTO;

@Controller
public class EmailControllerImpl implements EmailController {

	@Autowired
	private EmailService emailService;

	@Override
	public ResponseEntity<?> validateEmail(UUID xRequestID, EmailDTO emailDTO) {

		String validateEmail = emailService.validateEmail(emailDTO.getEmail());

		return ResponseEntity.ok(validateEmail);
	}

}
