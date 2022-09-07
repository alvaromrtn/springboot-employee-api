package com.axpe.exercices.presentation.controllers.impl;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.axpe.exercices.presentation.controllers.EmployeeController;

@Controller
public class EmployeeControllerImpl implements EmployeeController {

	@Override
	public ResponseEntity<Object> getRandomData(int id, UUID xRequestID) {

		System.out.print("HOLA");

		return null;
	}

}
