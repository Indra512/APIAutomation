package api.services;

import api.base.BaseService;
import api.models.request.TransactionRequest;
import io.restassured.response.Response;

public class TransactionService extends BaseService {
	
	public static final String END_POINT = "transactions";
	
	public Response createTransaction(TransactionRequest payload) {
		return postRequest(payload, END_POINT);
	}
}
