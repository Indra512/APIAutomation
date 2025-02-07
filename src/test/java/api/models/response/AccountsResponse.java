package api.models.response;

import java.util.List;

public class AccountsResponse {

	private List<AccountDetail> accounts;
	
	public AccountsResponse() {
		
	}

	public AccountsResponse(List<AccountDetail> accounts) {
		super();
		this.accounts = accounts;
	}

	public List<AccountDetail> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountDetail> accounts) {
		this.accounts = accounts;
	}
	
}
