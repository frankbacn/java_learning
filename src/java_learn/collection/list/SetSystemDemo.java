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
		//��Ϊ���ظ������޷��浽������

		//��������
		for(Iterator it = hs.iterator();it.hasNext();){
		    System.out.println(it.next());
		}
		//��Ϊ�ظ���������ֻ��������У�
		//ͬʱ���˳�������˳��ͬ
	}

}
