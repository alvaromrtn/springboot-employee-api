package com.axpe.exercices.service.impl;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.stereotype.Service;


import com.axpe.exercices.service.EmailService;

@Service

public class EmailServiceImpl implements EmailService {

	public String validateEmail(String email) {

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://api.tomba.io/v1/email-verifier/"+email))
				.header("content-type", "application/json")
				.header("X-Tomba-Key", "ta_fa57370cfcee370b374275c19054c40aca115")
				.header("X-Tomba-Secret", "ts_96727274-b784-4b9d-b642-78194fd00a7b")
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		HttpResponse<String> response;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());

			return response.body();
		} catch (IOException | InterruptedException e) {

			return null;
	}

}
	
}
