package three.multithreading.Timer;

import java.util.Timer;
import java.util.TimerTask;
class TimerExample{
  public static void main(String[] args) throws InterruptedException {
		
		Timer timer = new Timer();
		TimerTask badTask = new TimerTask() {
			
			public void run() {
				//System.out.println("Hello I am a ill-behaved task");
				try{
					throw new RuntimeException("Something bad happened");
				}catch(Exception ex) {
					System.out.println("Hello I am a ill-behaved task "
							+ "who throws an exception");
				}
			}
		};
		
		TimerTask goodTask = new TimerTask() {
			
			public void run() {
				System.out.println("Hello I am a well-behaved task");
			}
		};
		
		timer.schedule(badTask, 100);
		timer.schedule(goodTask, 400);
		Thread.sleep(500);
		timer.cancel();
	}
  /*When an earlier job fails with an unhandled exception the timer crashes or if is delayed, the subsequent jobs are delayed as well because timers only use a single thread*/
}