package com.dhruba.java.interfaceandabstraction.abstractclasses;

import com.dhruba.java.interfaceandabstraction.ClientEngagement;

public class RoyaltyCalculator extends RevenueCalculator {
	
	private double royaltyPercentage;
	
	public RoyaltyCalculator(double royaltyPercentage) {
		this.royaltyPercentage = royaltyPercentage;
	}


	@Override
	public double calculate(ClientEngagement clientEngagement) {
		printStatus();
		return royaltyPercentage * clientEngagement.getAnticipatedRevenue();
	}

}
