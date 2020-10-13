package com.dhruba.java.interfaceandabstraction.interfaces;

public class ClientEngagement {

	private final String client;
	private final int hoursWorked;
	private int id;

	public ClientEngagement(String client, int hoursWorked) {
		this.client = client;
		this.hoursWorked = hoursWorked;
	}

	public String getClient() {
		return client;
	}

	public int getHoursWorked() {
		return hoursWorked;
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ClientEngagement [client=" + client + ", hoursWorked=" + hoursWorked + ", id=" + id + "]";
	}

}
