package three.multithreading.ScheduledThreadPool;

import java.util.Calendar;

public class ThreadTask implements Runnable {

	public void run() {
		try {
			System.out.println("Thread executing at " + Calendar.getInstance().get(Calendar.SECOND));
		} catch (Exception Ex) {

		}

	}

}