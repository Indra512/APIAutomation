package api.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.testng.annotations.Test;

import api.models.request.AccountRequest;
import api.models.response.AccountDetail;
import api.models.response.AccountResponse;
import api.models.response.AccountsResponse;
import api.services.AccountService;
import io.restassured.response.Response;

public class CreateAccount {

	@Test(description = "Create A New Account - First Account")
	public void createFirstAccountTest() {
		AccountService accountService = new AccountService();
		AccountRequest accountRequest = new AccountRequest("John Cena", 0, "TESTBASH_POUNDS");
		Response response = accountService.createAccount(accountRequest);
		assertEquals(200, response.getStatusCode());
		System.out.println(response.getBody().asPrettyString());
		AccountResponse accountResponse = response.as(AccountResponse.class);
		System.out.println(accountResponse.getAccount().getId());
		assertNotNull(accountResponse.getAccount().getId());
	}

	@Test(description = "Create A New Account - Second Account")
	public void createSecondAccountTest() {
		AccountService accountService = new AccountService();
		AccountRequest accountRequest = new AccountRequest("HHH", 50, "TESTBASH_POUNDS");
		Response response = accountService.createAccount(accountRequest);
		assertEquals(200, response.getStatusCode());
		System.out.println(response.getBody().asPrettyString());
		AccountResponse accountResponse = response.as(AccountResponse.class);
		System.out.println(accountResponse.getAccount().getId());
		assertNotNull(accountResponse.getAccount().getId());
	}

	@Test(description = "Get All Accounts")
	public void getAllAccounts() {
		AccountService accountService = new AccountService();
		Response response = accountService.getAllAccounts();
		assertEquals(200, response.getStatusCode());
		System.out.println(response.getBody().asPrettyString());
		AccountsResponse accountsResponse = response.as(AccountsResponse.class);
		List<AccountDetail> accounts = accountsResponse.getAccounts();
		for (AccountDetail account : accounts) {
			System.out
					.println(account.getId() + "==" + account.getOwner() + "==" + account.getBalance()
							+ "==" + account.getCurrency() + "==" + account.getCreatedAt());
		}
	}
}
