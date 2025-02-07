package api.tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import api.models.request.TransactionRequest;
import api.services.TransactionService;
import api.utilities.Utils;
import io.restassured.response.Response;

public class TransactionsTest {

	@Test(description = "Create A New Transaction Between The Users")
	public void createTransactionsTest() {
		TransactionRequest transactionRequest = new TransactionRequest.Builder()
				.fromAccountId(Integer.parseInt(Utils.getDataFromCollection("second_user_account_id").trim()))
				.toAccountId(Integer.parseInt(Utils.getDataFromCollection("first_user_account_id").trim())).amount(20)
				.currency("TESTBASH_POUNDS").build();
		TransactionService transactionService = new TransactionService();
		Response response = transactionService.createTransaction(transactionRequest);
		System.out.println(response.getBody().asPrettyString());
		assertEquals(response.getBody().jsonPath().get("success").toString(), "true");
	}
}
