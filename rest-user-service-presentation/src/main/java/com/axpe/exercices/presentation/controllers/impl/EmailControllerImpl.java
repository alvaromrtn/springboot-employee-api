package com.axpe.exercices.presentation.controllers.impl;

import java.util.UUID;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.axpe.exercices.presentation.controllers.EmailController;

@Controller
public class EmailControllerImpl implements EmailController {

	@Override
	public ResponseEntity<?> validateEmail(UUID xRequestID, RequestEntity<?> data) {

		System.out.println("HOLA");
		System.out.println("HOLA");
		System.out.println("HOLA");

		return null;
	}

}
