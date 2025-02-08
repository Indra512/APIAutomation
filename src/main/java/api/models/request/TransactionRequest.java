package api.models.request;

public class TransactionRequest {

	private int fromAccountId;
	private int toAccountId;
	private int amount;
	private String currency;
	
	private TransactionRequest(int fromAccountId, int toAccountId, int amount, String currency) {
		super();
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.amount = amount;
		this.currency = currency;
	}

	public int getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(int fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public int getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(int toAccountId) {
		this.toAccountId = toAccountId;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public static class Builder {
		
		private int fromAccountId;
		private int toAccountId;
		private int amount;
		private String currency;
		
		public Builder fromAccountId(int fromAccountId) {
			this.fromAccountId = fromAccountId;
			return this;
		}
		
		public Builder toAccountId(int toAccountId) {
			this.toAccountId = toAccountId;
			return this;
		}
		
		public Builder amount(int amount) {
			this.amount = amount;
			return this;
		}
		
		public Builder currency(String currency) {
			this.currency = currency;
			return this;
		}
		
		public TransactionRequest build() {
			TransactionRequest transactionRequest = new TransactionRequest(fromAccountId, toAccountId, amount, currency);
			return transactionRequest;
		}	
	}
}
