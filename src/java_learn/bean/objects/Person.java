package java_learn.bean.objects;

public class Person implements Comparable{

	private String name;
    private int age;
    
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "name=" + name + ", age=" + age;
	}
	
	public int hashCode(){
		//ʹ�������Ĺ�ϣֵ������ĺ���Ϊ����Ĺ�ϣ��ֵ
		//Ϊ��֤��ϣ��ֵ�ܹ��������ڲ����ٵ���equals�����Ĵ���
		//��������һ��ֵ��ʹ��ֵ���ڲ��
		    return name.hashCode()+age*37;
		}

		public boolean equals(Object obj){
		//��Ҫ���ӽ�׳���ж��Ա�԰�����ͬ����
		//��Ǳ������ıȽ�����Ԥ�ȼ��

		    if(this == obj)
		        return true;
		    if(!(obj instanceof Person))
		        throw new ClassCastException("���ʹ���");
		    Person p = (Person)obj;
		    return (this.name.equals(p.name)) && (this.age == p.age);
		}

		@Override
		public int compareTo(Object o) {
			//��������Ϊ�����С�ıȽϷ�ʽ
			//��������ٱȽ��������ֵ�˳��
			if(!(o instanceof Person))
		        throw new ClassCastException("���ʹ���");
		    Person p = (Person)o;
		    if(this.age == p.age)
		        return name.compareTo(p.name);
		    else
		        return this.age - p.age;
		    
		    /*��ʦ�Ĵ���
		    int temp = age - p.age;
		    return temp == 0? name.compareTo(p.name):temp;
		    */
		}
    
}
