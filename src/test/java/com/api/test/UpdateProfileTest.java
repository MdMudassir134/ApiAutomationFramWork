package com.api.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.Base.AuthService;
import com.api.Base.UserManagementService;
import com.api.models.request.LoginRequest;
import com.api.models.request.PatchProfileUpdateRequest;
import com.api.models.request.UpdateProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

@Listeners(com.api.listeners.TestListener.class)
public class UpdateProfileTest {

	@Test(description = "Update user Profile details...")
	public void updateProfileTest() {
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("uday123", "uday123"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		System.out.println("------------------------------------------------------------------");
		UserManagementService userManagementService = new UserManagementService();
		response = userManagementService.getProfile(loginResponse.getToken());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		System.out.println(userProfileResponse.getFirstName());
		System.out.println("------------------------------------------------------------------");

		UpdateProfileRequest updateProfileRequest = new UpdateProfileRequest.Builder().firstName("Jatin")
				.lastName("sharma").email("sharma@gmail.com").mobileNumber("5535992972").build();
		response = userManagementService.updateProfile(loginResponse.getToken(), updateProfileRequest);
		System.out.println(response.asPrettyString());

	}

	@Test(description = "partial update user profile Data")
	public void patchUpdateUserProfileTest() {
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("uday123", "uday123"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		

		PatchProfileUpdateRequest patchProfileUpdateRequest = new PatchProfileUpdateRequest.Builder()
				.firstName("Mohammed").lastName("Uddin").mobileNumber("7890").build();
		UserManagementService userManagementService = new UserManagementService();
		response = userManagementService.patchUpdateProfile(loginResponse.getToken(), patchProfileUpdateRequest);
		System.out.println((response.asPrettyString()));
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
