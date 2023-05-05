package three.multithreading.ExecutorFramework.DumbExecutor;

class Task implements Runnable{
  public void run(){
    System.out.println("Task is running now ...");
  }
}