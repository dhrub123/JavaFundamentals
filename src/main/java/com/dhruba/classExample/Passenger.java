package com.dhruba.classExample;

public class Passenger {
	
	public Passenger(int checkedBags, int carryOns) {
		super();
		this.checkedBags = checkedBags;
		this.carryOns = carryOns;
	}

	int checkedBags;
	int carryOns;
	
	public int getCarryOns() {
		return carryOns;
	}

	public void setCarryOns(int carryOns) {
		this.carryOns = carryOns;
	}

	public int getCheckedBags() {
		return checkedBags;
	}

	public void setCheckedBags(int checkedBags) {
		this.checkedBags = checkedBags;
	}
	
	

}
