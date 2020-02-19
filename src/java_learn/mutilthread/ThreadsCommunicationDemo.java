package java_learn.mutilthread;

class Resource{
/*
������Դ����
*/
    private String name;
    private String sex;
	private boolean flag=false; //��Դ������ʶ
    //trueΪ�Դ棬falseΪδ��
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
    private Resource r; //��Ҫ��������Դ����
    private boolean flag = true; //���ڿ���δ��Դ��ֵ
    SetRes(Resource r){
    /*
    �ڴ����������ʱ����һ����Դ����
    �������������
    */
        this.r = r;
    }
    public void run(){
    //���ǽӿ��е�run����
        setResource();
    }
    private void setResource(){
    /*
    ������߳�����
    ����flag�ֱ����Դ����ֵ
    */
        String name,sex;
        while(true){
        	synchronized(r){
        		if(!r.getFlag()) {
		            if(flag){
		                name = "����";
		                sex = "��";
		                flag = false;
		            }else{
		                name = "����";
		                sex = "Ů";
		                flag = true;
		            }
		            r.setName(name);
		            r.setSex(sex);
		            //����ȴ�״̬
		            r.setFlag(true);
		            r.notify(); //���ѶԷ�
        			try {
        				r.wait();
        			}catch(InterruptedException e) {
        				
        			}
		        }else {
		        	//�����Դδ���ȡ������ֱ�ӵȴ�
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
    Resource r; //��Ҫ��������Դ����
    GetRes(Resource r){
    /*
    �ڴ����������ʱ����һ����Դ����
    �������������
    */
        this.r = r;
    }
    public void run(){
        getResource();
    }
    private void getResource(){
    /*
    ������߳�����
    ����Դ�л�ȡֵ�����㣨��ӡ��
    */
        while(true)
        	synchronized(r){
        		if(r.getFlag()) {
        			System.out.println("name:"+r.getName()+"...sex:"+r.getSex());
        			//ȡ����Ϻ�ȴ�
        			r.setFlag(false);
        			r.notify(); //���ѶԷ�
        			try {
        				r.wait();
        			}catch(InterruptedException e) {
        				
        			}
        		}else {
        			//���δ����ֱ�ӵȴ�
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
        /*������Դ����*/
        SetRes sr = new SetRes(r);
        GetRes gr = new GetRes(r);
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
