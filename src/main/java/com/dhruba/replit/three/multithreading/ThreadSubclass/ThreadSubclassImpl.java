package three.multithreading.ThreadSubclass;

class ThreadSubclassImpl extends Thread{
  public void run() {
    System.out.println("I ran after extending Thread class");
  }
}