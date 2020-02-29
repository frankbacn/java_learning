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
		 * ��ϰ��
		 * ��ȡ�ַ�����ÿһ����ĸ�ĳ��ִ���
		 * ��ӡ����ǣ�a(����),b(����),....
		 * 
		 */
		
		String str = "adsfbaqweqissdfesd";
		Character[] chars = toCharas(str); //Character�������飬���ڽ��ַ���ת��Ϊ�ַ��洢��List������
		List<Character> list = Arrays.asList(chars); //����List���ϲ��򼯺�������ַ�Ԫ��
		TreeMap<Character,Integer> tm = new TreeMap<Character, Integer>();
		putElements(list,tm);
		countKeys(tm,list);
		printOout(tm);
		
		
	}
	/**
	 * ����ָ����ʽ������
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
	 * ����Map�����еļ�����List������ַ����ֵĴ����������������Map����
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
	 * ��List�����е�Ԫ����Ϊ�����뵽Map������
	 * @param list
	 * @param tm
	 */
	private static void putElements(List<Character> list, TreeMap<Character, Integer> tm) {

		for(Character ch: list) {
			tm.put(ch, 0);
		}
		
	}
	/**
	 * ���ַ���תΪCharacter��������
	 * @param str ��Ҫת�����ַ���
	 * @return Character��������
	 */
	private static Character[] toCharas(String str) {
		Character[] chars = new Character[str.length()];
		for(int i = 0;i<str.length();i++) {
			chars[i] = str.charAt(i);
		}
		return chars;
	}

}
