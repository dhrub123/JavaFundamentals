package com.dhruba.java.interfaceandabstraction.abstractclasses;

import com.dhruba.java.interfaceandabstraction.ClientEngagement;

//We could have also defined an interface and implemented it 
public class HourlyRateCalculator extends RevenueCalculator {

	private double hourlyRate;

	public HourlyRateCalculator(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	@Override
	public double calculate(ClientEngagement clientEngagement) {
		printStatus();
		return clientEngagement.getHoursWorked() * hourlyRate;
	}

}
