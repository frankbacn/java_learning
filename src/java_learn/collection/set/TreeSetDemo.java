package java_learn.collection.set;

import java.util.Iterator;
import java.util.TreeSet;

import java_learn.bean.objects.Person;

public class TreeSetDemo {

	public static void main(String[] args) {

		TreeSet ts = new TreeSet();

		ts.add(new Person("小强",23));
		ts.add(new Person("小明",43));
		ts.add(new Person("张三",14));
		ts.add(new Person("王五",32));

		for(Iterator it = ts.iterator();it.hasNext();){
		    Person p = (Person)it.next();
		    System.out.println(p.getName()+"...."+p.getAge());
		}
	}

}
