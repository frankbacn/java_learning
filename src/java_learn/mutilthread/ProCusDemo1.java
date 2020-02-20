package java_learn.mutilthread;

class Res{
	//���ʶ���
	    private String resource;
	    //���嵥���Ĳ�Ʒ��Դ
	    private boolean flag=false;
	    //�����Ƿ�������ǣ�falseΪδ������trueΪ������
	    private int seq = 0;
	    //�����������к�
	    public synchronized void produceRes(String resource){
	        //�������ʵĲ���
	        while(flag)
	            try{wait();}catch(InterruptedException e){}
	        this.resource = resource+(++seq);
	        System.out.println(Thread.currentThread().getName()+"...������..."+this.resource);
	        flag = true;
	        notifyAll();
	        
	    }
	    public synchronized void getRes(){
	        //�������ʲ���
	        while(!flag)
	            try{wait();}catch(InterruptedException e){}

	        System.out.println(Thread.currentThread().getName()+".....������....."+resource);
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
        Producer p = new Producer(r,"��Ѽ");
        custemer c = new custemer(r);
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(c);
        t1.start();
        t2.start();

	}

}
