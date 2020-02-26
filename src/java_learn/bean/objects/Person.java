package java_learn.bean.objects;

public class Person {

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
		        
		    return (this.name.equals(((Person)obj).getName())) && (this.age == ((Person)obj).getAge());
		}
    
}
