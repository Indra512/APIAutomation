package api.models.response;

public class AccountResponse {
	
	private Account account;
	
	public AccountResponse() {
		
	}

	public AccountResponse(Account account) {
		super();
		this.account = account;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
