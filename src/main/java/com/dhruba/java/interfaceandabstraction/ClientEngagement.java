package com.dhruba.java.interfaceandabstraction;

public class ClientEngagement {

	private final String client;
	private final int hoursWorked;
	private final double anticipatedRevenue;

	public ClientEngagement(String client, int hoursWorked, double anticipatedRevenue) {
		this.client = client;
		this.hoursWorked = hoursWorked;
		this.anticipatedRevenue = anticipatedRevenue;
	}

	public String getClient() {
		return client;
	}

	public int getHoursWorked() {
		return hoursWorked;
	}

	public double getAnticipatedRevenue() {
		return anticipatedRevenue;
	}

	@Override
	public String toString() {
		return "ClientEngagement [client=" + client + ", hoursWorked=" + hoursWorked + ", anticipatedRevenue="
				+ anticipatedRevenue + "]";
	}

}
