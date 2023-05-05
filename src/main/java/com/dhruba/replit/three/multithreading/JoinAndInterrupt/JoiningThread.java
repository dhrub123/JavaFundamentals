package three.multithreading.JoinAndInterrupt;

class JoiningThread implements Runnable{

  public void run(){
    try{
      System.out.println("Going to Sleep");
      Thread.sleep(1000);
      System.out.println("Waking up");
    }catch(Exception ex){
      
    }
  }
}