package Lab3.Ex5;

public class RThread extends Thread{
    FileService service;
    public RThread(FileService service) {
        this.service = service;
    }

    public void run(){
        synchronized (this){
            while (!Main.isStopThreads()){
                try {
                    String readMsg = this.service.read();

                    System.out.println(readMsg);
                    System.out.println("gata citit");

                    Thread.sleep(3000);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
