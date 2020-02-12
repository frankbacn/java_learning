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
		//在计算机中创建一个小汽车的实例，通过new关键字。
        Car c = new Car(); //c是类类型引用变量，指向了该类型的对象。
        //给对象中的属性赋值。
        c.num = 4; 
        c.color = "red";
        
        c.run(); //要使用对象中的内容，可以使用对象.成员的方式来完成调用。

	}

}
