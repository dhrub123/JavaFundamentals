package three.multithreading.ScheduledThreadPool;

import java.util.Calendar;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class ScheduledThreadPoolExecutorExample {
	
	public static void main(String[] args) throws InterruptedException {
		
		ThreadTask task = new ThreadTask(); 
		System.out.println("Current Time = " + Calendar.getInstance().get(Calendar.SECOND));
		ScheduledThreadPoolExecutor threadpool = new ScheduledThreadPoolExecutor(4);
		threadpool.schedule(task, 5, TimeUnit.SECONDS);
		threadpool.schedule(task, 10, TimeUnit.SECONDS);
		threadpool.shutdown();
	}

}