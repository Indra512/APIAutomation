package api.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import api.services.AccountService;
import io.restassured.response.Response;

public class CreateAccount {
	
	@Test(description = "Create a new account - first account")
	public void createFirstAccountTest() {
		AccountService accountService = new AccountService();
		Response response = accountService.createAccount("{\"owner\": \"John Cena\",\"balance\": 0,\"currency\": \"TESTBASH_POUNDS\"}");
		assertEquals(200, response.getStatusCode());
		System.out.println(response.getBody().asPrettyString());
	}

	@Test(description = "Create a new account - second account")
	public void createSecondAccountTest() {
		AccountService accountService = new AccountService();
		Response response = accountService.createAccount("{\"owner\": \"HHH\",\"balance\": 50,\"currency\": \"TESTBASH_POUNDS\"}");
		assertEquals(200, response.getStatusCode());
		System.out.println(response.getBody().asPrettyString());
	}
	
	@Test(description = "Get all accounts")
	public void getAllAccounts() {
		AccountService accountService = new AccountService();
		Response response = accountService.getAllAccounts();
		assertEquals(200, response.getStatusCode());
		System.out.println(response.getBody().asPrettyString());
	}
}
