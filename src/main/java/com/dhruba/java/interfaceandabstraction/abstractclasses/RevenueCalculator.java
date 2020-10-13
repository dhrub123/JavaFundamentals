package com.dhruba.java.interfaceandabstraction.abstractclasses;

import com.dhruba.java.interfaceandabstraction.ClientEngagement;

public abstract class RevenueCalculator {
	
	public abstract double calculate(ClientEngagement clientEngagement);
	
	public void printStatus() {
		System.out.println("Calculation Started");
	}

}
