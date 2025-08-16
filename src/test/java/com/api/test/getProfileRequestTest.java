package com.api.test;

import org.testng.annotations.Test;

import com.api.Base.AuthService;
import com.api.Base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class getProfileRequestTest {
	@Test(description="the is to test user profile")
	public void getProfileInfoTest() {
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("uday123", "uday123"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
	
	
		UserManagementService userManagementService = new UserManagementService();
		 response =userManagementService.getProfile(loginResponse.getToken());
		 UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		 System.out.println(userProfileResponse.getUsername());
	}

}
