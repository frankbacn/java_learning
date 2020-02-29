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
	    //集合中存储的键值对信息是学号和姓名
	    
	    //添加演示
	    System.out.println(map.put(8,"旺财"));
	    //输出向map集合添加元素的返回结果,null
	    System.out.println(map.put(8,"小强"));
	    //输出向map集合相同键存储不同值的返回结果,旺财
	    
	    map.put(2,"sunny");
	    map.put(9,"dog");
	    
	    System.out.println(map);
	    
	    //删除演示
	    
	    System.out.println(map.remove(2));
	    //返回结果是sunny，同时结合长度缩短。
	    
	    System.out.println(map);
	    
	    //判断
	    System.out.println(map.containsKey(7));
	    //判断集合是否包含某个键
	    
	    //获取
	    System.out.println(map.get(7));
	    //获取一个集合中没有的键，返回结果为null
	    
	    
	}
	
	public static void method2(Map<Integer,String> map){
	    map.put(2,"sunny");
	    map.put(9,"dog");
	    map.put(11,"cat");
	    map.put(13,"frank");
	    
	    Iterator<Integer> it = map.keySet().iterator();
	    //获取keySet对象的迭代器
	    
	    while(it.hasNext()){
	        int key = it.next();
	        //遍历迭代器，并获取其每个元素。
	        System.out.println("key="+key+":value="+map.get(key));
	    }

	}
	/*map集合的第二中遍历方式，使用entrySet方法
	获取将键值对进行封装的set集合对象。再使用迭代
	器获取set集合中的每个对象，通过使用getKey方法
	和getValue方法获取对象中的键与值。
	*/
	public static void method3(Map<Integer,String> map){
	    //entrySet方法演示
	    map.put(2,"sunny");
	    map.put(9,"dog");
	    map.put(11,"cat");
	    map.put(13,"frank");
	    
	    /*
	    通过Map转成Set就能够实现迭代，
	    可以使用entrySet方法。该方法将键和值的映射
	    关系作为对象存储到了Set集合中。而这个映射
	    关系的类型就是Map.Entry类型。
	    Map.Entry接口是以内部接口，因为它直接访问
	    到了map集合中的内容。
	    */
	    
	    Set<Map.Entry<Integer,String>> entryset = map.entrySet();
	    //获取map集合键值映射关系集合
	    
	    Iterator<Map.Entry<Integer,String>> it = entryset.iterator();
	    
	    while(it.hasNext()){
	        Map.Entry<Integer,String> me = it.next();
	        System.out.println(me.getKey()+"..."+me.getValue());
	    }
	}
	
	//values方法演示
	/*
	values方法返回的是map集合的所有值组成的collection对象。因为在map集合中，键是唯一的，但值有可能重复。
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
