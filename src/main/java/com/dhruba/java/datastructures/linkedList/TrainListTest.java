package com.dhruba.java.datastructures.linkedList;

/**
 * Implement this class using java list method and compare the time
 *
 */
public class TrainListTest {
	
	BasicLinkedList<TrainCar> train = new BasicLinkedList<TrainCar>();
	
	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		TrainListTest app = new TrainListTest();
		app.buildInitialTrain();
		
		System.out.println("Initial train size = " + app.trainSize());
		
		app.firstStop();//remove a car and add couple more
		
		System.out.println("After first stop , train size = " + app.trainSize());
		
		app.secondStop();//remove tankers
		
		System.out.println("After second stop , train size = " + app.trainSize());
		
		app.lastStop();//remove all cars
		
		System.out.println("After last stop , train size = " + app.trainSize());
		long endTime = System.currentTimeMillis();
		System.out.println("Total time taken to execute = " + (endTime - startTime) + " ms");
	}
	
	private int trainSize() {
		return train.size();
	}
	
	private void buildInitialTrain() {
		TrainCar car1 = new TrainCar(CarType.BOXCAR, "Amazon Packages");
		TrainCar car2 = new TrainCar(CarType.FLATBED, "Farm Machinery");
		TrainCar car3 = new TrainCar(CarType.BOXCAR, "Paper");
		TrainCar car4 = new TrainCar(CarType.BOXCAR, "Grease");
		TrainCar car5 = new TrainCar(CarType.TANKER, "Crude Oil #1");
		TrainCar car6 = new TrainCar(CarType.TANKER, "Crude Oil #2");
		TrainCar car7 = new TrainCar(CarType.TANKER, "Crude Oil #3");
		TrainCar car8 = new TrainCar(CarType.FLATBED, "Empty Shipping Container");
		TrainCar car9 = new TrainCar(CarType.HOPPER, "Wheat Grain");
		TrainCar car10 = new TrainCar(CarType.HOPPER, "Coal");
		train.add(car1);train.add(car2);train.add(car3);train.add(car4);train.add(car5);
		train.add(car6);train.add(car7);train.add(car8);train.add(car9);train.add(car10);
		
		int position = train.find(car3);
		TrainCar paperCar = train.get(position);
		
		System.out.println("Found papercar at position " + train.find(paperCar));
		System.out.println(train);
	}
	
	public void firstStop() {
		TrainCar boxcar = train.remove();
		System.out.println("At first stop, removed a " + boxcar);
		
		train.insert(new TrainCar(CarType.BOXCAR, "Barbwire"), 1);
		System.out.println(train);
	}
	
	public void secondStop() {
		TrainCar car = train.removeAt(5);
		System.out.println("At second stop , removed " + car);
		
		car = train.removeAt(5);
		System.out.println("At second stop , removed " + car);
		
		car = train.removeAt(5);
		System.out.println("At second stop , removed " + car);
		
		System.out.println(train);
	}
	
	public void lastStop() {
		try {
			while(true) {
				TrainCar car = train.remove();
				System.out.println("At last stop, removed a " + car);
			}
		}catch(IllegalStateException ise) {
			ise.getMessage();
		}
		System.out.println(train);
	}

	private class TrainCar {
		private CarType type;
		private String contents;

		public TrainCar(CarType type, String contents) {
			this.type = type;
			this.contents = contents;
		}

		@Override
		public String toString() {
			return "TrainCar [type=" + type + ", contents=" + contents + "]";
		}

	}
	
	private enum CarType{
		BOXCAR, TANKER, FLATBED, HOPPER
	}
	
}
