package three.multithreading.ExecutorFramework.DumbExecutor;

class Exec{

  public static void main( String args[] ) {
    DummyExecutor executor = new DummyExecutor();
  Task t1 = new Task();
  executor.execute(t1);
  }
  
}