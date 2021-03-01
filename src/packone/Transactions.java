package packone;

public class Transactions {

	@Override
	public String toString() {
		return "Transactions [id=" + id + ", accountNumber=" + accountNumber + ", type=" + type + ", amount=" + amount
				+ ", time=" + time + ", Description=" + Description + "]";
	}

	String id,accountNumber,type,amount,time,Description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}
	
}
