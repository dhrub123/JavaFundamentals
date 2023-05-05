package three.multithreading.ExecutorFramework.Threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
class ThreadPoolExample{
  public static void main(String[] args){

    ExecutorService executor = Executors.newFixedThreadPool(10);
/*We also have newSingleThreadExecutor, newCachedThreadPool, newScheduledThreadPool */    
    for(int i = 1; i < 12; i++){
      Task t = new Task("" + i);
      executor.execute(t);
    }
    executor.shutdown();
    System.out.println("Finished Executing ....");
  }
}