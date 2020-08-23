package designpatterns.behavioral.observer;

public class TestObserver {
	
	public static void main(String[] args) {
		
		AverageScoreDisplay avg = new AverageScoreDisplay();
		CurrentScoreDisplay curr = new CurrentScoreDisplay();
		
		CricketData cdata = new CricketData();
		//Register observers
		cdata.registerObserver(avg);
		cdata.registerObserver(curr);
		
		//Data changes now
		cdata.dataChanged();
		
		//Remove observer
		cdata.unregisterObserver(avg);
		System.out.println("=================\nAfter removing average score\n===============");
		//Data changes again
		cdata.dataChanged();
	}
	
	
}
