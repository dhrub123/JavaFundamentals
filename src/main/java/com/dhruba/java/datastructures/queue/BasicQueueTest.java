package com.dhruba.java.datastructures.queue;

public class BasicQueueTest {
	
	Queue<Gad2Chair> gad2Lift = new BasicQueue<Gad2Chair>();
	
	public static void main(String[] args) {
		
		BasicQueueTest queueTest = new BasicQueueTest();
		queueTest.runLift();
	}
	
	private void runLift() {
		
		loadLift();
		System.out.println(gad2Lift.size());
		
		//does the lift contain skiers Mary and Anna
		System.out.println("Lift has Marry and Anna ? " 
				+ gad2Lift.contains(new Gad2Chair("Mary", "Anna")));
		
		//who is at the second position
		System.out.println("2nd chair has " + gad2Lift.access(1).listChairRiders());
		
		unloadLift();
		
		//if lift is unloaded again , error should occur since lift is empty
		try{
			unloadLift();
		}catch(IllegalStateException e) {
			System.out.println("Lift is empty " + e.getMessage());
		}
	}	
	
	private void loadLift() {
		
		Gad2Chair chair1 = new Gad2Chair("John", "Dave");
		Gad2Chair chair2 = new Gad2Chair("Samantha", "Kelly");
		Gad2Chair chair3 = new Gad2Chair("Mary", "Anna");
		Gad2Chair chair4 = new Gad2Chair("Robert", "Chad");
		Gad2Chair chair5 = new Gad2Chair("Sarah", "Bill");
		
		gad2Lift.enQueue(chair1);
		gad2Lift.enQueue(chair2);
		gad2Lift.enQueue(chair3);
		gad2Lift.enQueue(chair4);
		gad2Lift.enQueue(chair5);
	}
	
	private void unloadLift() {
		System.out.println(gad2Lift.size());
		
		for(int i = 0 ; i< 5; i++) {
			System.out.println(gad2Lift.dequeue().listChairRiders() + " unloaded");
		}
	}
	
	class Gad2Chair{
		
		private String firstOccupant;
		private String secondOccupant;
		
		public Gad2Chair(String firstOccupant, String secondOccupant) {
			this.firstOccupant = firstOccupant;
			this.secondOccupant = secondOccupant;
		}
		
		public String listChairRiders() {
			return "Riders are " + firstOccupant + " and " + secondOccupant + ".";
		}
		
		private BasicQueueTest getOuterType() {
			return BasicQueueTest.this;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((firstOccupant == null) ? 0 : firstOccupant.hashCode());
			result = prime * result + ((secondOccupant == null) ? 0 : secondOccupant.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Gad2Chair other = (Gad2Chair) obj;
			if(!getOuterType().equals(other.getOuterType()))
				return false;
			if (firstOccupant == null) {
				if (other.firstOccupant != null)
					return false;
			} else if (!firstOccupant.equals(other.firstOccupant))
				return false;
			if (secondOccupant == null) {
				if (other.secondOccupant != null)
					return false;
			} else if (!secondOccupant.equals(other.secondOccupant))
				return false;
			return true;
		}
		
		
	}

}


