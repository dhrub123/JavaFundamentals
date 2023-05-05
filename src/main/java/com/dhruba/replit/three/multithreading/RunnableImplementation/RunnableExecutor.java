package three.multithreading.RunnableImplementation;

class RunnableExecutor{

  public static void main(String[] args){

    RunnableTask task = new RunnableTask();
    Thread thread = new Thread(task);
    thread.start();
  }
  
}