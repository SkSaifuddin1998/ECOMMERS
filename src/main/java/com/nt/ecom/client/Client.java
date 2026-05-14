package com.nt.ecom.client;

public class Client {

	private final int clientId;

	private final String companyName;

	private final String ownerName;

	private final String email;

	private final String mobile;

	public Client(int clientId, String companyName, String ownerName, String email, String mobile) {

		this.clientId = clientId;
		this.companyName = companyName;
		this.ownerName = ownerName;
		this.email = email;
		this.mobile = mobile;
	}

	public int getClientId() {

		return clientId;
	}

	public String getCompanyName() {

		return companyName;
	}

	public String getOwnerName() {

		return ownerName;
	}

	public String getEmail() {

		return email;
	}

	public String getMobile() {

		return mobile;
	}

	@Override
	public String toString() {

		return "\nClient ID : " + clientId + "\nCompany : " + companyName + "\nOwner : " + ownerName + "\nEmail : "
				+ email + "\nMobile : " + mobile;
	}
}