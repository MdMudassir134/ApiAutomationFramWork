package com.api.test;

import org.testng.annotations.Test;

import com.api.Base.AuthService;
import com.api.Base.BaseService;

import io.restassured.response.Response;

public class ForgetPasswordTest {
	@Test(description="Forget password Test..!")
	public void forgetPasswordTest() {
		AuthService authService = new AuthService();
		Response response = authService.forgetPassword("Uday123@gmail.com");
		System.out.println(response.asPrettyString());
		
		
		
	}

}
