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
		
		al.add(new Person("Сǿ",23));
		al.add(new Person("С��",43));
		al.add(new Person("����",14));
		al.add(new Person("����",32));
		
		for(Iterator it = al.iterator();it.hasNext();){
			Person p = (Person)(it.next());
			System.out.println("name:"+p.getName()+",age:"+p.getAge());
		}
		
		for(Iterator it = al.iterator();it.hasNext();){
			System.out.println(it.hasNext());
		}
		
		
	}

	/**
	 * ���ϵļ̳б�����ʽ��ʾ
	 * @param list
	 */
	//����������ʹ����ʾ
	public static void show(){
	    Collection coll = new ArrayList();
	    coll.add("abc1");
	    coll.add("abc2");
	    coll.add("abc3");
	    
	    //��ȡ����������
	    Iterator it = coll.iterator();
	    //������������ȡ���󻹿���ʹ��
	    //���ܴ��ڲ���ȫ���ز�ռ���ڴ�ռ�
	    
	    //while��ʽ��ȡ�����е�Ԫ��
	    while(it.hasNext()){
	        it.next();
	    }
	    
	    //for��ʽ��ȡ������Ԫ��
	    for(Iterator it2 = coll.iterator();it2.hasNext();){
	        it2.next();
	    }
	    //������ʹ��
	}
	
	
	/**
	 * List��ϵı�����ʽ�����е�������ʾ
	 * @param list
	 */
	public static void listTraversals(List list) {
		//ͨ��ȡ����ʽ
		//��ʹ�õ������Ĺ����в��ܹ�ʹ�ü��ϲ���Ԫ�أ�
		//���ܻ�����ConcurrentModificationException�쳣��
		//���List���Ͽ���ʹ�õ��������ӽӿڶ���
		//ListIterator����ڵô��в���Ԫ�ء�
		for(Iterator it = list.iterator();it.hasNext();){
		    System.out.println(it.next());
		}

		//���б�����ʽ
		for(int x = 0;x<list.size();x++){
		    System.out.println(list.get(x));
		}

		//ListIterator������ʾ
		for(ListIterator lit = list.listIterator();lit.hasNext();){
		//��ȡ���������󲢱���
		    Object o = lit.next();
		    //��ȡԪ��
		    if(o.equals("xxx")){
		    //�жϲ��޸�Ԫ��
		        lit.set("yyy");
		    }
		    System.out.println(o);
		}
	}
	
	/**
	 * �������ɾ��������ʾ
	 * �������
	 * @param coll
	 */
	public static void show(Collection coll){
	    
	    //���Ԫ��
	    coll.add("abc1");
	    coll.add("abc2");
	    coll.add("abc3");
	    
	    //ɾ��Ԫ��
	    coll.remove("abc2");
	    //�����е�ɾ����������ı伯�ϵĳ���
	    
	    //��ռ���
	    coll.clear();
	}
	//����All�ķ�����ʾ
	public static void show(Collection c1,Collection c2){
	    //��c1���Ԫ��
	    c1.add("abc1");
	    c1.add("abc2");
	    c1.add("abc3");
	    //��c2���Ԫ��
	    c2.add("abc2");
	    c2.add("def2");
	    c2.add("def3");
	    
	    //��c2�е�Ԫ����ӵ�c1��
	    c1.addAll(c2);
	    
	    //removeAll��ʾ
	    c1.removeAll(c2);
	    //����������е���ͬԪ�شӵ���removeAll
	    //�ļ�����ɾ����
	    
	    //containsAll��ʾ
	    c1.containsAll(c2);
	    //�Ƚ϶���������������Ӽ��ŷ���true
	    
	    //retainAll��ʾ
	    c1.retainAll(c2);
	    //����ṹΪabc2��ֻ������ͬ��������
	}

}
