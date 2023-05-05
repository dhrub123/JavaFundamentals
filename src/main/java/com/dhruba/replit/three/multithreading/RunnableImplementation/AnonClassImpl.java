package three.multithreading.RunnableImplementation;

class AnonClassImpl{

  public static void main(String[] args){
    Thread thread = new Thread(
      new Runnable() {
        public void run(){
          System.out.println("We are running a thread");
        }
      }
    );
    thread.start();
  }
}