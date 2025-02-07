package api.tests;

import static org.testng.Assert.assertNotNull;

import org.testng.annotations.Test;

import api.services.AuthService;
import api.utilities.Utils;

public class GenerateTokenTest {
	
	@Test(description = "Generate New Token")
	public void generateNewTokenTest() {
		AuthService authService = new AuthService();
		String token = authService.getAuthToken();
		Utils.setDataInCollection("Token", token);
		assertNotNull(token);
	}
}
