package java_learn.bean.objects;

import java.util.Comparator;

public class ComparByName implements Comparator {

	@Override
	public int compare(Object arg0, Object arg1) {
		/*
		 * 按照姓名字典顺序进行比较
		 * 如果姓名相同再比较年龄
		 */
		if(!(arg0 instanceof Person))
			throw new ClassCastException("类型错误");
		if(!(arg1 instanceof Person)) 
			throw new ClassCastException("类型错误");
		Person p1 = (Person)arg0;
		Person p2 = (Person)arg1;
		int temp = p1.getName().compareTo(p2.getName());
	    return temp == 0? p1.getAge()-p2.getAge():temp;
	}

}
