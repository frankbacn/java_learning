package java_learn.map;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapTest {

	public static void main(String[] args) {

		/*
		 * 练习：
		 * 获取字符串中每一个字母的出现次数
		 * 打印结果是：a(次数),b(次数),....
		 * 
		 */
		
		String str = "adsfbaqweqissdfesd";
		Character[] chars = toCharas(str); //Character类型数组，用于将字符串转换为字符存储到List集合中
		List<Character> list = Arrays.asList(chars); //定义List集合并向集合中添加字符元素
		TreeMap<Character,Integer> tm = new TreeMap<Character, Integer>();
		putElements(list,tm);
		countKeys(tm,list);
		printOout(tm);
		
		
	}
	/**
	 * 按照指定方式输出结果
	 * @param tm
	 */
	private static void printOout(TreeMap<Character, Integer> tm) {

		for(Map.Entry<Character, Integer> me:tm.entrySet()) {
			Character key = me.getKey();
			Integer value = me.getValue();
			System.out.print(key+"("+value+"), ");
		}
	}
	/**
	 * 按照Map集合中的键搜索List结合中字符出现的次数，并将结果存入Map集合
	 * @param tm
	 * @param list
	 */
	private static void countKeys(TreeMap<Character, Integer> tm, List<Character> list) {

		for(Iterator<Character> it = tm.keySet().iterator();it.hasNext();) {
			Character ch = it.next();
			int count = Collections.frequency(list, ch);
			tm.put(ch, count);
		}
		
		
	}
	/**
	 * 将List集合中的元素作为键存入到Map集合中
	 * @param list
	 * @param tm
	 */
	private static void putElements(List<Character> list, TreeMap<Character, Integer> tm) {

		for(Character ch: list) {
			tm.put(ch, 0);
		}
		
	}
	/**
	 * 将字符串转为Character类型数组
	 * @param str 需要转换的字符串
	 * @return Character类型数组
	 */
	private static Character[] toCharas(String str) {
		Character[] chars = new Character[str.length()];
		for(int i = 0;i<str.length();i++) {
			chars[i] = str.charAt(i);
		}
		return chars;
	}

}
