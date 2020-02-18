package java_learn.mutilthread;

class Bank implements Runnable{
    private int total = 0; //总资金
    Object obj = new Object();
    
    public void run(){
        for(int i=0;i<3;i++){
        //循环内语句需要同步
            synchronized (obj) {	
                total += 100;
                //线程存入100元
                System.out.println(Thread.currentThread().getName()+"存储入100，总资金是"+total);
            }
        }
    }
}

public class SyncTest {

	public static void main(String[] args) {
		Bank b = new Bank();
        Thread t1 = new Thread(b);
        Thread t2 = new Thread(b);
        t1.start();
        t2.start();

	}

}
