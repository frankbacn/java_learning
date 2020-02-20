package java_learn.mutilthread;

class Res{
	//物资对象
	    private String resource;
	    //定义单个的产品资源
	    private boolean flag=false;
	    //物资是否生产标记，false为未生产，true为已生产
	    private int seq = 0;
	    //物资生产序列号
	    public synchronized void produceRes(String resource){
	        //生产物资的操作
	        while(flag)
	            try{wait();}catch(InterruptedException e){}
	        this.resource = resource+(++seq);
	        System.out.println(Thread.currentThread().getName()+"...生产了..."+this.resource);
	        flag = true;
	        notifyAll();
	        
	    }
	    public synchronized void getRes(){
	        //消费物资操作
	        while(!flag)
	            try{wait();}catch(InterruptedException e){}

	        System.out.println(Thread.currentThread().getName()+".....消费了....."+resource);
	        flag = false;
	        notifyAll();	     
	    }	    
}
	class Producer implements Runnable{
	    private Res r;
	    private String resource;
	    Producer(Res r,String resource){
	        this.r = r;
	        this.resource = resource;
	    }
	    public void run(){
	        while(true){
	            r.produceRes(resource);
	        }
	    }
	}
	class custemer implements Runnable{
	    private Res r;
	    custemer(Res r){
	        this.r = r;
	    }
	    public void run(){
	        while(true){
	            r. getRes();
	        }
	    }
	}

public class ProCusDemo1 {

	public static void main(String[] args) {
		Res r = new Res();
        Producer p = new Producer(r,"烤鸭");
        custemer c = new custemer(r);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();

	}

}
