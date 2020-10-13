package com.dhruba.java.interfaceandabstraction.abstractclasses;

import java.util.Arrays;
import java.util.List;

import com.dhruba.java.interfaceandabstraction.ClientEngagement;

public class RevenueCalculatorRunner {

	private static final double STANDARD_HOURLY_RATE = 50;
	private static final double FIXED_FEE = 500;
	private static final double ROYALTY_PERCENTAGE = 0.15;

	public static void main(String[] args) {

		final ClientEngagement clientEngagement = new ClientEngagement("Pluralsight", 100, 15_000);

		RevenueCalculator revenueCalculator = new HourlyRateCalculator(STANDARD_HOURLY_RATE);
		System.out.println("Hourly Fee = " + revenueCalculator.calculate(clientEngagement));

		revenueCalculator = new FixedFeeCalculator(FIXED_FEE);
		System.out.println("Fixed Fee = " + revenueCalculator.calculate(clientEngagement));

		revenueCalculator = new RoyaltyCalculator(ROYALTY_PERCENTAGE);
		System.out.println("Royalty Revenue = " + revenueCalculator.calculate(clientEngagement));

		final List<ClientEngagement> engagements = Arrays.asList(new ClientEngagement("Cat cookies", 40, 40_000),
				new ClientEngagement("Bob burger", 30, 4_000), new ClientEngagement("Dave donut", 25, 1_000),
				new ClientEngagement("Susan sausage", 10, 2_000));

		double total;
		total = calculateTotalRevenue(engagements, new FixedFeeCalculator(FIXED_FEE));
		System.out.println("Fixed Fee total = " + total);

		total = calculateTotalRevenue(engagements, new HourlyRateCalculator(STANDARD_HOURLY_RATE));
		System.out.println("Standard Fee total = " + total);

		total = calculateTotalRevenue(engagements, new RoyaltyCalculator(ROYALTY_PERCENTAGE));
		System.out.println("Royalty revenue total = " + total);

	}

	private static double calculateTotalRevenue(final List<ClientEngagement> engagements,
			RevenueCalculator revenueCalculator) {
		double total = 0.0;
		for (ClientEngagement engagement : engagements) {
			total += revenueCalculator.calculate(engagement);
		}
		return total;
	}

}
