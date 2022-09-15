package com.axpe.exercices.presentation.controllers;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.axpe.exercices.presentation.http.CustomHeaders;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Tag(name = "Email", description = "API Email")
public interface EmailController {

	@Operation(description = "Validate an email.", operationId = "validateEmail", summary = "Validate an email")
	@RequestMapping(value = "/validateEmail", method = RequestMethod.POST)
	@ResponseBody
	ResponseEntity<?> validateEmail(@RequestHeader(value = CustomHeaders.X_REQUEST_ID, required = true) UUID xRequestID,
			@RequestBody String email);

}
