package api.base;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	private static final String BASE_URL = "https://template.postman-echo.com/api/v1/";
	protected RequestSpecification requestSpecification;
	private static final ThreadLocal<String> authToken = new ThreadLocal<String>();
	
	public BaseService() {
		this.requestSpecification = given().baseUri(BASE_URL);
	}
	
	protected Response getRequest(String endpoint) {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("api-key", getAuthToken());
		headers.put("Content-Type", "application/json");
		return requestSpecification.headers(headers).get(endpoint);
	}
	
	protected Response postRequest(String payload, String endpoint) {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("api-key", getAuthToken());
		headers.put("Content-Type", "application/json");
		return requestSpecification.headers(headers).body(payload).post(endpoint);
	}
	
	protected String getAuthToken() {
		String token = authToken.get();
		if (token == null) {
			System.out.println("Generating token");
			token = requestSpecification.get("auth").getBody().jsonPath().get("apiKey").toString();
			authToken.set(token);
		}
		return token;
	}
}
