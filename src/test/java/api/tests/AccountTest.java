package api.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.util.List;

import org.testng.annotations.Test;

import api.models.request.AccountRequest;
import api.models.request.TransactionRequest;
import api.models.response.AccountDetail;
import api.models.response.AccountResponse;
import api.models.response.AccountsResponse;
import api.services.AccountClosureService;
import api.services.AccountService;
import api.services.TransactionService;
import api.utilities.Utils;
import io.restassured.response.Response;

public class AccountTest {

	@Test(description = "Create A New Account - First Account")
	public void createFirstAccountTest() {
		AccountRequest accountRequest = new AccountRequest("John Cena", 0, "TESTBASH_POUNDS");
		AccountService accountService = new AccountService();
		Response response = accountService.createAccount(accountRequest);
		assertEquals(200, response.getStatusCode());
		System.out.println(response.getBody().asPrettyString());
		AccountResponse accountResponse = response.as(AccountResponse.class);
		Utils.setDataInCollection("first_user_account_id", String.valueOf(accountResponse.getAccount().getId()));
		assertNotNull(accountResponse.getAccount().getId());
	}

	@Test(description = "Create A New Account - Second Account")
	public void createSecondAccountTest() {
		AccountRequest accountRequest = new AccountRequest("HHH", 50, "TESTBASH_POUNDS");
		AccountService accountService = new AccountService();
		Response response = accountService.createAccount(accountRequest);
		assertEquals(200, response.getStatusCode());
		System.out.println(response.getBody().asPrettyString());
		AccountResponse accountResponse = response.as(AccountResponse.class);
		assertNotNull(accountResponse.getAccount().getId());
		Utils.setDataInCollection("second_user_account_id", String.valueOf(accountResponse.getAccount().getId()));
		response = accountService.getAccount(Utils.getDataFromCollection("second_user_account_id"));
		System.out.println(response.getBody().asPrettyString());
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
