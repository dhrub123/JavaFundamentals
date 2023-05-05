package three.multithreading.ThreadSubclass;

class ThreadSubclassImplExecutor{
  public static void main(String[] args) throws InterruptedException{
    
    ThreadSubclassImpl threadTask = new ThreadSubclassImpl();
    threadTask.start();
    threadTask.join();
  }
}