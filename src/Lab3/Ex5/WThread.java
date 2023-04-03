package Lab3.Ex5;

public class WThread extends Thread{

    FileService service;
    public WThread(FileService service) {
        this.service = service;
    }

    public void run(){
        synchronized (this){
            while(!Main.isStopThreads()) {
                String msg =
                        String.valueOf(Math.round(Math.random() * 100));

                this.service.write(msg);     System.out.println("gata scris");

                try {
                    Thread.sleep(2000);

                } catch (InterruptedException e) {

                    e.printStackTrace();
                }
            }
        }
    }
}
