package api.models.request;

public class AccountRequest {

	private String owner;
	private int balance;
	private String currency;
	
	public AccountRequest(String owner, int balance, String currency) {
		super();
		this.owner = owner;
		this.balance = balance;
		this.currency = currency;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
