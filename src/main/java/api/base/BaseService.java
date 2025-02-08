package api.base;

import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import api.filters.LoggingFilter;
import api.utilities.Utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

	private static final String BASE_URL = "https://template.postman-echo.com/api/v1/";
	protected RequestSpecification requestSpecification;
	
	static {
		RestAssured.filters(new LoggingFilter());
	}

	public BaseService() {
		this.requestSpecification = given().baseUri(BASE_URL);
	}

	protected String getAuthToken(String endpoint) {
		return requestSpecification.get(endpoint).getBody().jsonPath().get("apiKey").toString();
	}
	
	protected Response getRequest(String endpoint) {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("api-key", Utils.getDataFromCollection("Token"));
		headers.put("Content-Type", "application/json");
		return requestSpecification.headers(headers).get(endpoint);
	}

	protected Response postRequest(Object payload, String endpoint) {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("api-key", Utils.getDataFromCollection("Token"));
		headers.put("Content-Type", "application/json");
		return requestSpecification.headers(headers).body(payload).post(endpoint);
	}

	protected Response deleteRequest(String endpoint) {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("api-key", Utils.getDataFromCollection("Token"));
		headers.put("Content-Type", "application/json");
		return requestSpecification.headers(headers).delete(endpoint);
	}
}
