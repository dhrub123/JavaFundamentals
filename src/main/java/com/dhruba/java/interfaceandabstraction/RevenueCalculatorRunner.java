package com.dhruba.java.interfaceandabstraction;

public class RevenueCalculatorRunner {

	public static void main(String[] args) {

		final ClientEngagement clientEngagement = new ClientEngagement("Pluralsight", 100, 15_000);
		final double hourlyPrice = RevenueCalculatorBad.price("Hourly", clientEngagement);
		System.out.println("Hourly Price = " + hourlyPrice);
		final double fixedFee = RevenueCalculatorBad.price("FixedFee", clientEngagement);
		System.out.println("Fixed Fee = " + fixedFee);
		final double royaltyPercentagePrice = RevenueCalculatorBad.price("RoyaltyPercentage", clientEngagement);
		System.out.println("Royalty Percentage Price = " + royaltyPercentagePrice);

	}
}
