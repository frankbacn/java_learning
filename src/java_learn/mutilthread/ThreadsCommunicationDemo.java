package java_learn.mutilthread;

class Resource{
/*
定义资源对象
*/
    private String name;
    private String sex;
	private boolean flag=false; //资源操作标识
    //true为以存，false为未存
    Resource(){}
    Resource(String name,String sex){
        this.name = name;
        this.sex = sex;
    }
    public String getName(){
        return name;
    }
    public String getSex(){
        return sex;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSex(String sex){
        this.sex = sex;
    }
    public void setFlag(boolean flag){
        this.flag = flag;
    }
    public boolean getFlag(){
        return flag;
    }
}

class SetRes implements Runnable{
    private Resource r; //需要操作的资源对象
    private boolean flag = true; //用于控制未资源赋值
    SetRes(Resource r){
    /*
    在创建任务对象时接收一个资源对象
    用于任务操作。
    */
        this.r = r;
    }
    public void run(){
    //覆盖接口中的run方法
        setResource();
    }
    private void setResource(){
    /*
    具体的线程任务
    根据flag分别给资源对象赋值
    */
        String name,sex;
        while(true){
        	synchronized(r){
        		if(!r.getFlag()) {
		            if(flag){
		                name = "张三";
		                sex = "男";
		                flag = false;
		            }else{
		                name = "李四";
		                sex = "女";
		                flag = true;
		            }
		            r.setName(name);
		            r.setSex(sex);
		            //进入等待状态
		            r.setFlag(true);
		            r.notify(); //唤醒对方
        			try {
        				r.wait();
        			}catch(InterruptedException e) {
        				
        			}
		        }else {
		        	//如果资源未完成取出动作直接等待
		        	try {
        				r.wait();
        			}catch(InterruptedException e) {
        				
        			}
		        }
        	}
        }
    }
}
class GetRes implements Runnable{
    Resource r; //需要操作的资源对象
    GetRes(Resource r){
    /*
    在创建任务对象时接收一个资源对象
    用于任务操作。
    */
        this.r = r;
    }
    public void run(){
        getResource();
    }
    private void getResource(){
    /*
    具体的线程任务
    从资源中获取值并运算（打印）
    */
        while(true)
        	synchronized(r){
        		if(r.getFlag()) {
        			System.out.println("name:"+r.getName()+"...sex:"+r.getSex());
        			//取出完毕后等待
        			r.setFlag(false);
        			r.notify(); //唤醒对方
        			try {
        				r.wait();
        			}catch(InterruptedException e) {
        				
        			}
        		}else {
        			//如果未存入直接等待
        			try {
        				r.wait();
        			}catch(InterruptedException e) {
        				
        			}
        		}
        	}
    }
}

public class ThreadsCommunicationDemo {

	public static void main(String[] args) {
		Resource r = new Resource();
        /*创建资源对象*/
        SetRes sr = new SetRes(r);
        GetRes gr = new GetRes(r);
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
