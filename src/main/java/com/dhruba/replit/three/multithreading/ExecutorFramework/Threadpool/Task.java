package three.multithreading.ExecutorFramework.Threadpool;

class Task implements Runnable{
  
  public Task(String message){
    this.message = message;
  }

  private String message;
  
  public void run(){
          System.out.println("Executing concurrent thread" + message);}
}