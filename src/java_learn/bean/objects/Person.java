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
		//使用姓名的哈希值与年龄的和作为对象的哈希码值
		//为保证哈希码值能够尽量存在差距减少调用equals方法的次数
		//可在最后乘一个值以使数值存在差距
		    return name.hashCode()+age*37;
		}

		public boolean equals(Object obj){
		//需要增加健壮性判断以便对包括相同对象
		//或非本类对象的比较做出预先检查

		    if(this == obj)
		        return true;
		    if(!(obj instanceof Person))
		        throw new ClassCastException("类型错误");
		    Person p = (Person)obj;
		    return (this.name.equals(p.name)) && (this.age == p.age);
		}

		@Override
		public int compareTo(Object o) {
			//以年龄作为对象大小的比较方式
			//年龄相等再比较姓名的字典顺序
			if(!(o instanceof Person))
		        throw new ClassCastException("类型错误");
		    Person p = (Person)o;
		    if(this.age == p.age)
		        return name.compareTo(p.name);
		    else
		        return this.age - p.age;
		    
		    /*老师的代码
		    int temp = age - p.age;
		    return temp == 0? name.compareTo(p.name):temp;
		    */
		}
    
}
