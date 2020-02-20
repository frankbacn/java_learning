package java_learn.mutilthread;

class Producer2 implements Runnable{
	    private Res r;
	    private String resource;
	    Producer2(Res r,String resource){
	        this.r = r;
	        this.resource = resource;
	    }
	    public void run(){
	        while(true){
	            r.produceRes(resource);
	        }
	    }
	}
	class custemer2 implements Runnable{
	    private Res r;
	    custemer2(Res r){
	        this.r = r;
	    }
	    public void run(){
	        while(true){
	            r. getRes();
	        }
	    }
	}

public class ProCusDemo2 {

	public static void main(String[] args) {
		Res r = new Res();
        Producer2 p = new Producer2(r,"¿¾Ñ¼");
        custemer2 c = new custemer2(r);
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
