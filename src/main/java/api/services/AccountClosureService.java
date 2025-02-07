package api.services;

import api.base.BaseService;
import io.restassured.response.Response;

public class AccountClosureService extends BaseService {

	public static final String END_POINT = "accounts";

	public Response deleteAccount(String accountId) {
		return deleteRequest(END_POINT + "/" + accountId);
	}
}
