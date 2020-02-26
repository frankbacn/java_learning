package java_learn.collection.set;

import java.util.HashSet;
import java.util.Iterator;

import java_learn.bean.objects.Person;

public class HashSetDemo {

	public static void main(String[] args) {

		//HashSet演示

//		hashSetDemo1();
		/*
		将多个Person对象存储到HashSet集合中，
		人对象的姓名和年龄相同则视为同一个人。
		*/

//		hashSetDemo2();
		
		
	}

	public static void hashSetDemo2() {
		HashSet hs = new HashSet();

		hs.add(new Person("小强",23));
		hs.add(new Person("小明",43));
		hs.add(new Person("张三",14));
		hs.add(new Person("王五",32));

		hs.add(new Person("张三",14));
		//再次存入具有相同属性值的对象，仍然可以存储到集合中

		for(Iterator it = hs.iterator();it.hasNext();){
		    Person p = (Person)it.next();
		    System.out.println(p.getName()+"...."+p.getAge());
		}
	}

	public static void hashSetDemo1() {
		HashSet hs = new HashSet();

		hs.add("haha");
		hs.add("hehe");
		hs.add("heihei");
		hs.add("xixi");

		hs.add("heihei");
		hs.add("heihei");
		//因为数重复所以无法存到集合中

		//遍历集合
		for(Iterator it = hs.iterator();it.hasNext();){
		    System.out.println(it.next());
		}
		//因为重复数据所以只会输出四行，
		//同时输出顺序与存入顺序不同
	}

}
