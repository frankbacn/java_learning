package java_learn.mutilthread;

class Resources{
/*
������Դ����
*/
    private String name;
    private String sex;
	private boolean flag=false; //��Դ������ʶ
    //trueΪ�Դ棬falseΪδ�� 
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
    private Resources r; //��Ҫ��������Դ����
    private boolean flag = true; //���ڿ���δ��Դ��ֵ
    SetReso(Resources r){
    /*
    �ڴ����������ʱ����һ����Դ����
    �������������
    */
        this.r = r;
    }
    public void run(){
    //���ǽӿ��е�run����
    	while(true)
	        if(flag){
	        	r.set("zhangsan", "Male");
	        	flag = false;
	        }else {
	        	r.set("����", "Ů");
	        	flag = true;
	        }
    }
    
}
class GetReso implements Runnable{
    Resources r; //��Ҫ��������Դ����
    GetReso(Resources r){
    /*
    �ڴ����������ʱ����һ����Դ����
    �������������
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
        /*������Դ����*/
        SetReso sr = new SetReso(r);
        GetReso gr = new GetReso(r);
        /*�ֱ𴴽��߳��������
        ������Ҫ��������Դ��Ϊ��������*/
        Thread t1 = new Thread(sr);
        Thread t2 = new Thread(gr);
        /*���������߳�
        �ֱ��Ӧ�����߳�����*/
        t1.start();
        t2.start();
        //�����߳�

	}

}
