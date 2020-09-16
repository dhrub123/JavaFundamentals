package com.dhruba.java.concurrency.falsesharing;

public class FalseSharingExample {
	
	public static int NUM_THREAD_MAX = 4;
	public final static long ITERATIONS = 50_000_000L;
	
	private static VolatileLongPadded[] paddedLongs;
	private static VolatileLongUnPadded[] unPaddedLongs;
	
	public final static class VolatileLongPadded{
		public long q1, q2, q3, q4, q5, q6;
		public volatile long value = 0L;
		public long q11, q12, q13, q14, q15, q16;
	}
	
	public static final class VolatileLongUnPadded{
		public volatile long value = 0L;
	}
	
	static {
		paddedLongs = new VolatileLongPadded[NUM_THREAD_MAX];
		for(int i = 0; i < paddedLongs.length; i++) {
			paddedLongs[i] = new VolatileLongPadded();
		}
		unPaddedLongs = new VolatileLongUnPadded[NUM_THREAD_MAX];
		for(int i = 0; i < unPaddedLongs.length; i++) {
			unPaddedLongs[i] = new VolatileLongUnPadded();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		runBenchmark();
	}
	
	private static void runBenchmark() throws InterruptedException{
		long begin, end;
		for(int i = 1; i<= NUM_THREAD_MAX; i++) {
			
			Thread[] threads = new Thread[i];
			
			for(int j=0; j< threads.length; j++) {
				threads[j] = new Thread(createPaddedRunnable(j));
			}
			begin = System.currentTimeMillis();
			for(Thread t: threads) {t.start();}
			for(Thread t: threads) {t.join();}
			end = System.currentTimeMillis();
			System.out.printf(" Padded # threads %d - T = %dms\n", i, end - begin);
			
			for(int j=0; j< threads.length; j++) {
				threads[j] = new Thread(createUnPaddedRunnable(j));
			}
			begin = System.currentTimeMillis();
			for(Thread t: threads) {t.start();}
			for(Thread t: threads) {t.join();}
			end = System.currentTimeMillis();
			System.out.printf(" UnPadded # threads %d - T = %dms\n\n", i, end - begin);
			
		}
	}
	
	private static Runnable createPaddedRunnable(final int k) {
		return () -> {
			long i = ITERATIONS + 1;
			while(0 != --i) {
				paddedLongs[k].value = i;
			}
		};
	}
	
	private static Runnable createUnPaddedRunnable(final int k) {
		return () -> {
			long i = ITERATIONS + 1;
			while(0 != --i) {
				unPaddedLongs[k].value = i;
			}
		};
	}
	
	/**
	 * 
	 * Output : 
	 * 
	 *  Padded # threads 1 - T = 326ms
 UnPadded # threads 1 - T = 318ms

 Padded # threads 2 - T = 323ms
 UnPadded # threads 2 - T = 1449ms

 Padded # threads 3 - T = 318ms
 UnPadded # threads 3 - T = 2804ms

 Padded # threads 4 - T = 324ms
 UnPadded # threads 4 - T = 4271ms

So we can see, that with increase in threads, false sharing results in high performance hit.
	 */
	
}
