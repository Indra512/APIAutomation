package api.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import api.services.AccountClosureService;
import api.utilities.Utils;
import io.restassured.response.Response;

public class AccountClosuresTest {
	
	@Test(description = "Delete The User Account - First Account")
	public void deleteFirstAccountTest() {
		AccountClosureService accountClosureService = new AccountClosureService();
		Response response = accountClosureService.deleteAccount(Utils.getDataFromCollection("first_user_account_id"));
		System.out.println(response.getBody().asPrettyString());
		assertEquals(response.getBody().jsonPath().get("success").toString(), "true");
	}
	
	@Test(description = "Delete The User Account - Second Account")
	public void deleteSecondAccountTest() {
		AccountClosureService accountClosureService = new AccountClosureService();
		Response response = accountClosureService.deleteAccount(Utils.getDataFromCollection("second_user_account_id"));
		System.out.println(response.getBody().asPrettyString());
		assertEquals(response.getBody().jsonPath().get("success").toString(), "true");
	}
}
