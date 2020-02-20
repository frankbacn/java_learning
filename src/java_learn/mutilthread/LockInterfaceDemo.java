package java_learn.mutilthread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resou{
	//���ʶ���
		private Lock lock = new ReentrantLock();
		//����һ��������
		private Condition m1 = lock.newCondition();
		private Condition m2 = lock.newCondition();
		//������������������
	    private String resource;
	    //���嵥���Ĳ�Ʒ��Դ
	    private boolean flag=false;
	    //�����Ƿ�������ǣ�falseΪδ������trueΪ������
	    private int seq = 0;
	    //�����������к�
	    public void produceRes(String resource){
	        //�������ʵĲ���
	    	lock.lock();
	    	try{	    		
		        while(flag)
		            try{m1.await();;}catch(InterruptedException e){}
		        this.resource = resource+(++seq);
		        System.out.println(Thread.currentThread().getName()+"...������..."+this.resource);
		        flag = true;
		        m2.signalAll();;
	    	}finally{
	    		lock.unlock();
	    	}
	        
	    }
	    public void getRes(){
	        //�������ʲ���
	    	lock.lock();
	    	try{	    		
		        while(!flag)
		            try{m2.await();;}catch(InterruptedException e){}
	
		        System.out.println(Thread.currentThread().getName()+".....������....."+resource);
		        flag = false;
		        m1.signalAll();;
	    	}finally{
	    		lock.unlock();
	    	}
	    }	    
}

class Pro implements Runnable{
    private Resou r;
    private String resource;
    Pro(Resou r,String resource){
        this.r = r;
        this.resource = resource;
    }
    public void run(){
        while(true){
            r.produceRes(resource);
        }
    }
}
class Cons implements Runnable{
    private Resou r;
    Cons(Resou r){
        this.r = r;
    }
    public void run(){
        while(true){
            r. getRes();
        }
    }
}


public class LockInterfaceDemo {

	public static void main(String[] args) {
		Resou r = new Resou();
        Pro p = new Pro(r,"��Ѽ");
        Cons c = new Cons(r);
        Thread t0 = new Thread(p);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        Thread t3 = new Thread(c);
        t0.start();
        t1.start();
        t2.start();
        t3.start();

	}

}
