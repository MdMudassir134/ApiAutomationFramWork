package com.api.Base;

import java.util.HashMap;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignUpRequest;

import io.restassured.response.Response;
//auth service
public class AuthService extends BaseService {
	private final static String BASE_PATH ="/api/auth/";
	
	public Response login(LoginRequest payload) {
		return postRequest(payload, BASE_PATH + "login");	
		
	}
	public Response signUp(SignUpRequest payload) {
		return postRequest(payload, BASE_PATH+"signup");
	}
	public Response forgetPassword(String emailAddress) {
		HashMap<String,String>payload = new HashMap<>();
		payload.put("email", emailAddress);
		return postRequest(payload,BASE_PATH+"forgot-password");
	}

}
