package api.models.response;

import java.util.Date;

public class AccountDetail {

	private int id;
	private String owner;
	private int balance;
	private String currency;
	private Date createdAt;

	public AccountDetail() {

	}

	public AccountDetail(int id, String owner, int balance, String currency, Date createdAt) {
		super();
		this.id = id;
		this.owner = owner;
		this.balance = balance;
		this.currency = currency;
		this.createdAt = createdAt;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
}
