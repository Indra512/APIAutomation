package api.services;

import api.base.BaseService;
import io.restassured.response.Response;

public class AuthService extends BaseService {
	
	public static final String END_POINT = "auth";
	
	public String getAuthToken() {
		return getAuthToken(END_POINT);
	}
}
