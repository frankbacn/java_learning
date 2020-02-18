package java_learn.mutilthread;

class Ticket implements Runnable{
    private int tickets = 100;
    public void run(){
        while(true){
            sale();
        }
    }
    public synchronized void sale(){
        if(tickets>0){
            try{Thread.sleep(50);}catch(InterruptedException e){}
            System.out.println(Thread.currentThread().getName()+"....."+tickets--);
        }
    }
}

public class SyncFunctionDemo {

	public static void main(String[] args) {
		Ticket t = new Ticket();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        Thread t3 = new Thread(t);
        Thread t4 = new Thread(t);
        t1.start();
        t2.start();
        t3.start();
        t4.start();

	}

}
