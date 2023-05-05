package three.multithreading.IntegerAddition;

class Sum {

  private long start;
  private long end;
  private static long max = Integer.MAX_VALUE;
  private long counter = 0;

  public Sum(long start, long end) {
    this.start = start;
    this.end = end;
  }

  public void add() {
    for (long i = start; i <= end; i++) {
      counter = counter + i;
    }
  }

  public static void oneThread() {
    long start = System.currentTimeMillis();
    Sum sum = new Sum(1, max);
    sum.add();
    long end = System.currentTimeMillis();
    System.out.println("Sum = " + sum.counter + " and time taken = " + (end - start) + " ms");
  }

  public static void twoThreads() throws InterruptedException {
    long start = System.currentTimeMillis();
    long halfway = max / 2;
    Sum sum1 = new Sum(1, halfway);
    Sum sum2 = new Sum(1 + halfway, max);
    Thread t1 = new Thread(() -> {
      sum1.add();
    });
    Thread t2 = new Thread(() -> {
      sum2.add();
    });
    t1.start();
    t2.start();

    t1.join();
    t2.join();
    long result = sum1.counter + sum2.counter;
    long end = System.currentTimeMillis();
    System.out.println("Sum = " + result + " and time taken = " + (end - start) + " ms");
  }

  public static void test() throws InterruptedException {
    oneThread();
    twoThreads();
  }

}