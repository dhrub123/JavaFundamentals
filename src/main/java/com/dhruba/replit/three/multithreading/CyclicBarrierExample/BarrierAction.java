package three.multithreading.CyclicBarrierExample;

public class BarrierAction implements Runnable {

	public void run() {
		System.out.println("All parties have arrived, proceed with execution");
	}

}