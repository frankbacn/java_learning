package java_learn.collection.set;

import java.util.HashSet;
import java.util.Iterator;

import java_learn.bean.objects.Person;

public class HashSetDemo {

	public static void main(String[] args) {

		//HashSet��ʾ

//		hashSetDemo1();
		/*
		�����Person����洢��HashSet�����У�
		�˶����������������ͬ����Ϊͬһ���ˡ�
		*/

//		hashSetDemo2();
		
		
	}

	public static void hashSetDemo2() {
		HashSet hs = new HashSet();

		hs.add(new Person("Сǿ",23));
		hs.add(new Person("С��",43));
		hs.add(new Person("����",14));
		hs.add(new Person("����",32));

		hs.add(new Person("����",14));
		//�ٴδ��������ͬ����ֵ�Ķ�����Ȼ���Դ洢��������

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
		//��Ϊ���ظ������޷��浽������

		//��������
		for(Iterator it = hs.iterator();it.hasNext();){
		    System.out.println(it.next());
		}
		//��Ϊ�ظ���������ֻ��������У�
		//ͬʱ���˳�������˳��ͬ
	}

}
