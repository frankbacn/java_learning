package java_learn.mutilthread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Resou{
	//物资对象
		private Lock lock = new ReentrantLock();
		//创建一个锁对象
		private Condition m1 = lock.newCondition();
		private Condition m2 = lock.newCondition();
		//创建两个监视器对象
	    private String resource;
	    //定义单个的产品资源
	    private boolean flag=false;
	    //物资是否生产标记，false为未生产，true为已生产
	    private int seq = 0;
	    //物资生产序列号
	    public void produceRes(String resource){
	        //生产物资的操作
	    	lock.lock();
	    	try{	    		
		        while(flag)
		            try{m1.await();;}catch(InterruptedException e){}
		        this.resource = resource+(++seq);
		        System.out.println(Thread.currentThread().getName()+"...生产了..."+this.resource);
		        flag = true;
		        m2.signalAll();;
	    	}finally{
	    		lock.unlock();
	    	}
	        
	    }
	    public void getRes(){
	        //消费物资操作
	    	lock.lock();
	    	try{	    		
		        while(!flag)
		            try{m2.await();;}catch(InterruptedException e){}
	
		        System.out.println(Thread.currentThread().getName()+".....消费了....."+resource);
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
        Pro p = new Pro(r,"烤鸭");
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
