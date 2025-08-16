package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.Base.AuthService;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class AccountCreationTest {
	@Test(description="Create an Account")
	public void createAccount() {
		SignUpRequest signUpRequest= new SignUpRequest.Builder().email("mohammedd1243@gmail.com")
		 .password("mohammed123")
		 .userName("mohammeddd")
		 .mobileNumber("2604834921")
		 .firstName("mohammed")
		 .lastName("ussin")
		 .build();
		
		AuthService authService = new AuthService();
		Response response = authService.signUp(signUpRequest);
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
		
	}
}
