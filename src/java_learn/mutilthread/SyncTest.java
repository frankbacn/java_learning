package java_learn.mutilthread;

class Bank implements Runnable{
    private int total = 0; //���ʽ�
    Object obj = new Object();
    
    public void run(){
        for(int i=0;i<3;i++){
        //ѭ���������Ҫͬ��
            synchronized (obj) {	
                total += 100;
                //�̴߳���100Ԫ
                System.out.println(Thread.currentThread().getName()+"�洢��100�����ʽ���"+total);
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
