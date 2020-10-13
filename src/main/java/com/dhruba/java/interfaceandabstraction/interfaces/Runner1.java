package com.dhruba.java.interfaceandabstraction.interfaces;

public class Runner1 {
	
	public static void main(String[] args) {
		
		ClientEngagementRepository repository = null;
		
		final Iterable<ClientEngagement> engagements = 
				repository.find(new Query().atLeastHoursWorked(3).client("PluralSight"));
	}
}
