package java_learn.OOP;

class Car{
    int num;
    String color;
    
    void run(){
        System.out.println(num+"..."+color);
    }
}

public class OOPbase {

	public static void main(String[] args) {
		//�ڼ�����д���һ��С������ʵ����ͨ��new�ؼ��֡�
        Car c = new Car(); //c�����������ñ�����ָ���˸����͵Ķ���
        //�������е����Ը�ֵ��
        c.num = 4; 
        c.color = "red";
        
        c.run(); //Ҫʹ�ö����е����ݣ�����ʹ�ö���.��Ա�ķ�ʽ����ɵ��á�

	}

}
