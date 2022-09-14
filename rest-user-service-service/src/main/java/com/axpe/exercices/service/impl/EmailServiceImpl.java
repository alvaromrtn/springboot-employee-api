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

	public boolean validateEmail(String email) {

		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("https://global-email-v4.p.rapidapi.com/v4/WEB/GlobalEmail/doGlobalEmail?email=" + email
						+ "&opt=VerifyMailbox%3AExpress%7CVerifyMailbox%3AExpressPremium&format=json"))
				.header("X-RapidAPI-Key", "86a8266baemshdd9dcfa0f7e2261p123116jsn55a0acec42af")
				.header("X-RapidAPI-Host", "global-email-v4.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody()).build();
		HttpResponse<String> response;
		try {
			response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(response.body());

			return true;
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return false;
		}
	}

}
