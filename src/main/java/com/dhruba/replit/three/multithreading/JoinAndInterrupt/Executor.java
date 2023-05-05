package three.multithreading.JoinAndInterrupt;

class Executor{
  public static void main(String[] args) throws InterruptedException{
    JoiningThread join = new JoiningThread();
    Thread inner = new Thread(join);
    inner.setDaemon(true);
    inner.start();
    inner.join();
    /**
    innner.join ensures that the main thread will wait for the inner thread to complete,
    setting a thread as daemon means it will be torn down if main completes, we have to use join to make the main wait, inner.interrupt means main will exit at the point of interruption even if inner has not completed
    **/
  }
}