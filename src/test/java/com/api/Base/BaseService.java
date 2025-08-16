package com.api.Base;

import static io.restassured.RestAssured.*;

import com.api.filters.LogginFilter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public abstract class BaseService {
	private final static String BASE_URL = "http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;
	
	static {
		RestAssured.filters(new LogginFilter());
	}

	public BaseService() {
		requestSpecification = given().baseUri(BASE_URL);
	}
	
	protected void setAuthToken(String token) {
		requestSpecification.header("Authorization", "Bearer "+token);
				
	}

	protected Response postRequest(Object payload, String endPoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endPoint);
	}
	protected Response putRequest(Object payload,String endPoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endPoint);
	}
	protected Response patchRequest(Object payload,String endPoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).patch(endPoint);
	}

	protected Response getRequest(String endPoint) {
		return requestSpecification.contentType(ContentType.JSON).get(endPoint);
	}

}
