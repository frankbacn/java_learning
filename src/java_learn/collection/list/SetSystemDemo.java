package java_learn.collection.list;

import java.util.HashSet;
import java.util.Iterator;

public class SetSystemDemo {

	public static void main(String[] args) {

		hashSetShow();
	}

	public static void hashSetShow() {
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
