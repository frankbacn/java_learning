package java_learn.mutilthread;

class Resources{
/*
定义资源对象
*/
    private String name;
    private String sex;
	private boolean flag=false; //资源操作标识
    //true为以存，false为未存 
    public synchronized void set(String name,String sex){
        if(flag)
            try{wait();}catch(InterruptedException e){}
        this.name = name;
        this.sex = sex;
        flag = true;
        notify();
    }
    
    public synchronized void show(){
        if(!flag)
            try{wait();}catch(InterruptedException e){}
        System.out.println("name:"+name+"...sex:"+sex);
        flag = false;
        notify();
    }
}

class SetReso implements Runnable{
    private Resources r; //需要操作的资源对象
    private boolean flag = true; //用于控制未资源赋值
    SetReso(Resources r){
    /*
    在创建任务对象时接收一个资源对象
    用于任务操作。
    */
        this.r = r;
    }
    public void run(){
    //覆盖接口中的run方法
    	while(true)
	        if(flag){
	        	r.set("zhangsan", "Male");
	        	flag = false;
	        }else {
	        	r.set("丽丽", "女");
	        	flag = true;
	        }
    }
    
}
class GetReso implements Runnable{
    Resources r; //需要操作的资源对象
    GetReso(Resources r){
    /*
    在创建任务对象时接收一个资源对象
    用于任务操作。
    */
        this.r = r;
    }
    public void run(){
    	while(true)
    		r.show();
    }
}

public class ThreadsCommunicationDemo2 {

	public static void main(String[] args) {
		Resources r = new Resources();
        /*创建资源对象*/
        SetReso sr = new SetReso(r);
        GetReso gr = new GetReso(r);
        /*分别创建线程任务对象
        并将需要操作的资源作为参数传递*/
        Thread t1 = new Thread(sr);
        Thread t2 = new Thread(gr);
        /*创建两个线程
        分别对应两个线程任务*/
        t1.start();
        t2.start();
        //启动线程

	}

}
