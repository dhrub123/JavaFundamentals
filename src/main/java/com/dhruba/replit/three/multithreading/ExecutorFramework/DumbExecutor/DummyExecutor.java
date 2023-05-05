package three.multithreading.ExecutorFramework.DumbExecutor;

import java.util.concurrent.Executor;
class DummyExecutor implements Executor{

  public void execute(Runnable runnable){
    Thread thread = new Thread(runnable);
    thread.start();
  }
}