package com.nt.ecom.client;

public class ClientBuilder {

	private int clientId;

	private String companyName;

	private String ownerName;

	private String email;

	private String mobile;

	public ClientBuilder clientId(int clientId) {

		this.clientId = clientId;

		return this;
	}

	public ClientBuilder companyName(String companyName) {

		this.companyName = companyName;

		return this;
	}

	public ClientBuilder ownerName(String ownerName) {

		this.ownerName = ownerName;

		return this;
	}

	public ClientBuilder email(String email) {

		this.email = email;

		return this;
	}

	public ClientBuilder mobile(String mobile) {

		this.mobile = mobile;

		return this;
	}

	public Client build() {

		return new Client(clientId, companyName, ownerName, email, mobile);
	}
}