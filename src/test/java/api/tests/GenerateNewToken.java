package api.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import api.services.AuthService;
import io.restassured.response.Response;

public class GenerateNewToken {
	
	@Test(description = "Generate New Token")
	public void generateNewTokenTest() {
		AuthService authService = new AuthService();
		Response response = authService.generateToken();
		String token = response.getBody().jsonPath().get("apiKey").toString();
		assertEquals(response.getStatusCode(), 200);
	}
}
