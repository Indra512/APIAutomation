package api.services;

import api.base.BaseService;
import api.models.request.AccountRequest;
import io.restassured.response.Response;

public class AccountService extends BaseService {
	
	public static final String END_POINT = "accounts";
	
	public Response createAccount(AccountRequest payload) {
		return postRequest(payload, END_POINT);
	}
	
	public Response getAllAccounts() {
		return getRequest(END_POINT);
	}
}
