package designpatterns.behavioral.observer;

import java.util.ArrayList;
import java.util.Iterator;

public class CricketData implements Subject {

	int runs, wickets;
	float overs;
	ArrayList<Observer> observers;

	public CricketData() {
		observers = new ArrayList<Observer>();
	}

	public void registerObserver(Observer o) {
		observers.add(o);

	}

	public void unregisterObserver(Observer o) {
		observers.remove(observers.indexOf(o));

	}

	public void notifyObservers() {
		for (Iterator<Observer> it = observers.iterator(); it.hasNext();) {
			Observer o = it.next();
			o.update(runs, wickets, overs);
		}
	}

	private int getLatestRuns() {
		return 90;
	}

	private int getLatestWickets() {
		return 2;
	}

	private float getLatestOvers() {
		return (float) 10.2;
	}

	public void dataChanged() {
		runs = getLatestRuns();
		wickets = getLatestWickets();
		overs = getLatestOvers();

		notifyObservers();
	}

}
