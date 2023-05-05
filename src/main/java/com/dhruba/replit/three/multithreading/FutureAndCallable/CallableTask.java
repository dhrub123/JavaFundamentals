package three.multithreading.FutureAndCallable;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<Long> {

	long begin;
	long end;

	public CallableTask(long begin, long end) {
		this.begin = begin;
		this.end = end;
	}

	public Long call() throws Exception {

		long sum = 0;

		if (end <= 0) {
			return sum;
		}

		for (long i = begin; i <= end; i++) {
			sum = sum + i;
		}
		return sum;
	}

}