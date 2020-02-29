package java_learn.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {

		 Map<Integer,String> map = new HashMap<Integer,String>();
		    method3(map);
	}
	public static void method(Map<Integer,String> map){
	    //�����д洢�ļ�ֵ����Ϣ��ѧ�ź�����
	    
	    //�����ʾ
	    System.out.println(map.put(8,"����"));
	    //�����map�������Ԫ�صķ��ؽ��,null
	    System.out.println(map.put(8,"Сǿ"));
	    //�����map������ͬ���洢��ֵͬ�ķ��ؽ��,����
	    
	    map.put(2,"sunny");
	    map.put(9,"dog");
	    
	    System.out.println(map);
	    
	    //ɾ����ʾ
	    
	    System.out.println(map.remove(2));
	    //���ؽ����sunny��ͬʱ��ϳ������̡�
	    
	    System.out.println(map);
	    
	    //�ж�
	    System.out.println(map.containsKey(7));
	    //�жϼ����Ƿ����ĳ����
	    
	    //��ȡ
	    System.out.println(map.get(7));
	    //��ȡһ��������û�еļ������ؽ��Ϊnull
	    
	    
	}
	
	public static void method2(Map<Integer,String> map){
	    map.put(2,"sunny");
	    map.put(9,"dog");
	    map.put(11,"cat");
	    map.put(13,"frank");
	    
	    Iterator<Integer> it = map.keySet().iterator();
	    //��ȡkeySet����ĵ�����
	    
	    while(it.hasNext()){
	        int key = it.next();
	        //����������������ȡ��ÿ��Ԫ�ء�
	        System.out.println("key="+key+":value="+map.get(key));
	    }

	}
	/*map���ϵĵڶ��б�����ʽ��ʹ��entrySet����
	��ȡ����ֵ�Խ��з�װ��set���϶�����ʹ�õ���
	����ȡset�����е�ÿ������ͨ��ʹ��getKey����
	��getValue������ȡ�����еļ���ֵ��
	*/
	public static void method3(Map<Integer,String> map){
	    //entrySet������ʾ
	    map.put(2,"sunny");
	    map.put(9,"dog");
	    map.put(11,"cat");
	    map.put(13,"frank");
	    
	    /*
	    ͨ��Mapת��Set���ܹ�ʵ�ֵ�����
	    ����ʹ��entrySet�������÷���������ֵ��ӳ��
	    ��ϵ��Ϊ����洢����Set�����С������ӳ��
	    ��ϵ�����;���Map.Entry���͡�
	    Map.Entry�ӿ������ڲ��ӿڣ���Ϊ��ֱ�ӷ���
	    ����map�����е����ݡ�
	    */
	    
	    Set<Map.Entry<Integer,String>> entryset = map.entrySet();
	    //��ȡmap���ϼ�ֵӳ���ϵ����
	    
	    Iterator<Map.Entry<Integer,String>> it = entryset.iterator();
	    
	    while(it.hasNext()){
	        Map.Entry<Integer,String> me = it.next();
	        System.out.println(me.getKey()+"..."+me.getValue());
	    }
	}
	
	//values������ʾ
	/*
	values�������ص���map���ϵ�����ֵ��ɵ�collection������Ϊ��map�����У�����Ψһ�ģ���ֵ�п����ظ���
	*/
	public void method4(Map<Integer,String> map){
	    map.put(2,"sunny");
	    map.put(9,"dog");
	    map.put(11,"cat");
	    map.put(13,"frank");
	    
	    Collection<String> coll = map.values();
	    
	    Iterator<String> it = coll.iterator();
	    
	    while(it.hasNext()){
	        System.out.println(it.next());
	    }
	}
	
	
	

}
