package com.dhruba.classExample;

public class Overloading {
	
	int seats = 150, passengers, totalCheckedBags , maxCarryOns = seats * 2, totalCarryOns;
	
	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public int getPassengers() {
		return passengers;
	}

	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}

	public int getTotalCheckedBags() {
		return totalCheckedBags;
	}

	public void setTotalCheckedBags(int totalCheckedBags) {
		this.totalCheckedBags = totalCheckedBags;
	}

	public int getMaxCarryOns() {
		return maxCarryOns;
	}

	public void setMaxCarryOns(int maxCarryOns) {
		this.maxCarryOns = maxCarryOns;
	}

	public int getTotalCarryOns() {
		return totalCarryOns;
	}

	public void setTotalCarryOns(int totalCarryOns) {
		this.totalCarryOns = totalCarryOns;
	}

	public void add1Passenger() {
		if(hasSeating()) {
			passengers += 1;
		}else {
			handleTooMany();
		}
	}
	
	public void add1Passenger(int bags) {
		
		if(hasSeating()) {
			add1Passenger();
			totalCheckedBags += bags;
		}else {
			handleTooMany();
		}
	}
	
	public void add1Passenger(int bags, int carryOns) {
			
		if(hasSeating() && hasCarryOnSpace(carryOns)) {
			add1Passenger(bags);
			totalCarryOns += carryOns;
		}else {
			handleTooMany();
		}
	}
	
	//convenience overloads
	public void add1Passenger(Passenger p) {
		add1Passenger(p.getCheckedBags(),p.getCarryOns());
	}
	
	//variable parameters denoted by an ellipse ...
	public void addPassengers(Passenger... list) {
		if(hasSeating(list.length)) {
			passengers += list.length;
			for(Passenger passenger : list) {
				totalCheckedBags += passenger.getCheckedBags();
				totalCarryOns += passenger.getCarryOns();
			}
		}else {
			handleTooMany();
		}
	}

	
	private boolean hasSeating(int count) {
		return passengers + count <= seats;
	}
	
	private boolean hasSeating() {
		return passengers <= seats;
	}
	
	private boolean hasCarryOnSpace(int carryOns) {
		return totalCarryOns + carryOns <= maxCarryOns;
	}
	
	private void handleTooMany() {
		System.out.println("Too Many passengers");
	}
	
	public static void main(String[] args) {
		
		Overloading flight = new Overloading();
		Passenger p1 = new Passenger(0,1);
		Passenger p2 = new Passenger(1,2);
		
		flight.add1Passenger();
		flight.add1Passenger(2);
		flight.add1Passenger(p1);
		flight.add1Passenger(p2);
		
		short threeBags = 3;
		flight.add1Passenger(threeBags, 2);
		
		System.out.println(flight.toString());
		
		//variable parameters ...
		Passenger p3 = new Passenger(0,2);
		Passenger p4 = new Passenger(1,2);
		flight.addPassengers(p3,p4);
		
		System.out.println(flight.toString());
		
	}

	@Override
	public String toString() {
		return "Overloading [seats=" + seats + ", passengers=" + passengers + ", totalCheckedBags=" + totalCheckedBags
				+ ", maxCarryOns=" + maxCarryOns + ", totalCarryOns=" + totalCarryOns + "]";
	}
	
	

}
