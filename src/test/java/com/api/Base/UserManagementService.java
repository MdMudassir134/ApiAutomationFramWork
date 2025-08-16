package com.api.Base;

import com.api.models.request.PatchProfileUpdateRequest;
import com.api.models.request.UpdateProfileRequest;

import io.restassured.response.Response;

public class UserManagementService extends BaseService {
	private static final String BASE_PATH = "/api/users/";

	public Response getProfile(String token) {
		setAuthToken(token);
		return getRequest(BASE_PATH + "profile");

	}
	public Response updateProfile(String token,UpdateProfileRequest payload) {
		setAuthToken(token);
		return putRequest(payload, BASE_PATH+"profile");
	}
	public Response patchUpdateProfile(String token, PatchProfileUpdateRequest payload) {
		setAuthToken(token);
		return patchRequest(payload, BASE_PATH+"profile" );
	}

}
