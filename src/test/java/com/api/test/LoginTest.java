package com.api.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.Base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class LoginTest {
	@Test(description = "verifing login api is working..!")
	public void validLoginTest() {
		LoginRequest loginRequest = new LoginRequest("uday123", "uday123");
		
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		System.out.println(loginResponse.getEmail());
		System.out.println(loginResponse.getUsername());
		System.out.println(loginResponse.getToken());
		
		assertTrue(loginResponse.getToken()!=null);
		assertEquals(loginResponse.getEmail(), "sharma@gmail.com");
	}
	

}
