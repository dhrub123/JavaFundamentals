package com.dhruba.java.interfaceandabstraction.abstractclasses;

import com.dhruba.java.interfaceandabstraction.ClientEngagement;

public class FixedFeeCalculator extends RevenueCalculator {

	private double fixedFee;

	public FixedFeeCalculator(double fixedFee) {
		this.fixedFee = fixedFee;
	}

	@Override
	public double calculate(ClientEngagement clientEngagement) {
		printStatus();
		return fixedFee;
	}

}
