package java_learn.collection.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import java_learn.bean.objects.Person;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		

		ArrayList al = new ArrayList();
		
		al.add(new Person("小强",23));
		al.add(new Person("小明",43));
		al.add(new Person("张三",14));
		al.add(new Person("王五",32));
		
		for(Iterator it = al.iterator();it.hasNext();){
			Person p = (Person)(it.next());
			System.out.println("name:"+p.getName()+",age:"+p.getAge());
		}
		
		for(Iterator it = al.iterator();it.hasNext();){
			System.out.println(it.hasNext());
		}
		
		
	}

	/**
	 * 集合的继承遍历方式演示
	 * @param list
	 */
	//迭代器对象使用演示
	public static void show(){
	    Collection coll = new ArrayList();
	    coll.add("abc1");
	    coll.add("abc2");
	    coll.add("abc3");
	    
	    //获取迭代器对象
	    Iterator it = coll.iterator();
	    //迭代器对象在取出后还可以使用
	    //可能存在不安全因素并占用内存空间
	    
	    //while方式获取集合中的元素
	    while(it.hasNext()){
	        it.next();
	    }
	    
	    //for方式获取集合中元素
	    for(Iterator it2 = coll.iterator();it2.hasNext();){
	        it2.next();
	    }
	    //开发中使用
	}
	
	
	/**
	 * List结合的遍历方式与特有迭代器演示
	 * @param list
	 */
	public static void listTraversals(List list) {
		//通用取出方式
		//在使用迭代器的过程中不能够使用集合操作元素，
		//可能会引发ConcurrentModificationException异常。
		//针对List集合可以使用迭代器的子接口对象
		//ListIterator完成在得带中操作元素。
		for(Iterator it = list.iterator();it.hasNext();){
		    System.out.println(it.next());
		}

		//特有遍历方式
		for(int x = 0;x<list.size();x++){
		    System.out.println(list.get(x));
		}

		//ListIterator遍历演示
		for(ListIterator lit = list.listIterator();lit.hasNext();){
		//获取迭代器对象并遍历
		    Object o = lit.next();
		    //获取元素
		    if(o.equals("xxx")){
		    //判断并修改元素
		        lit.set("yyy");
		    }
		    System.out.println(o);
		}
	}
	
	/**
	 * 集合添加删除功能演示
	 * 单个添加
	 * @param coll
	 */
	public static void show(Collection coll){
	    
	    //添加元素
	    coll.add("abc1");
	    coll.add("abc2");
	    coll.add("abc3");
	    
	    //删除元素
	    coll.remove("abc2");
	    //集合中的删除操作将会改变集合的长度
	    
	    //清空集合
	    coll.clear();
	}
	//带有All的方法演示
	public static void show(Collection c1,Collection c2){
	    //给c1添加元素
	    c1.add("abc1");
	    c1.add("abc2");
	    c1.add("abc3");
	    //给c2添加元素
	    c2.add("abc2");
	    c2.add("def2");
	    c2.add("def3");
	    
	    //将c2中的元素添加到c1中
	    c1.addAll(c2);
	    
	    //removeAll演示
	    c1.removeAll(c2);
	    //将两个结合中的相同元素从调用removeAll
	    //的集合中删除。
	    
	    //containsAll演示
	    c1.containsAll(c2);
	    //比较对象必须是完整的子集才返回true
	    
	    //retainAll演示
	    c1.retainAll(c2);
	    //运算结构为abc2，只保留相同部分内容
	}

}
