package java_learn.IO.bytestream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class ProperitesDemo {

	public static void main(String[] args) throws IOException {
		demo();
//		myload();
		setValue();
	}
	
	/**
	 * 修改配置文件中的某个属性并保存
	 * @throws IOException 
	 */
	private static void setValue() throws IOException {
		
		File cf = new File("config.conf");
		//将配置文件封装成对象
		if(!cf.exists()){//判断文件是否存在，如果不存在则创建新文件
			System.out.println("true");
			cf.createNewFile();			
			demo();//初始化文件内容
		}		
		FileReader fr = new FileReader(cf);
		//创建读取流		
		Properties p = new Properties();
		//创建集合
		p.load(fr);
		//加载文件中数据到集合中
		p.setProperty("conf1", "new value");
		//修改某个属性的值
		p.list(System.out);
		//显示修改结果
		FileWriter fw =  new FileWriter(cf);
		//创建写入流,因为关联的文件相同所以需要在存储前再创建写入流，否则会覆盖文件内容
		p.store(fw, "change value");
		//保存变更
		fr.close();
		fw.close();
	}
	
	/**
	 * 模拟Properties对象的load方法
	 * 获取文件中的信息并加载到集合中
	 * @throws IOException
	 */
	private static void myload() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("config.conf"));
		//创建流对象
		Properties p = new Properties();
		//创建集合对象
		String line = null;
		//定义读取行的临时变量
		while((line = br.readLine())!=null){
			if(line.startsWith("#")) //判断行是否为注释
				continue;
			String[] configs = line.split("=");
			//以等号将行中内容分割为独立的键值对信息临时存储
			p.put(configs[0], configs[1]);
			/*
			 * 将临时存储的键值对信息存储到集合中
			 * 键是第一个元素，角标为0
			 * 值是第二个元素，角标为1
			 */
			
		}
		p.list(System.out);
		//显示集合中结构
		br.close();
	}

	private static void demo2() throws IOException {
		Properties p = new Properties();
		//创建属性集合对象
		FileReader fr = new FileReader("config.conf");
		//创建读取流
		p.load(fr);
		//从文件中将信息加载到内存
		Set<String> keys = p.stringPropertyNames();
		//获取集合中的所有键
		for(String key:keys){ //循环获取键值对信息
			String value = p.getProperty(key);
			System.out.println(key+":"+value);
		}
	}

	public static void demo() throws IOException {
		
		Properties p = new Properties();
		//创建Properties对象
		p.put("conf1", "value1");
		p.put("conf2", "value2");
		p.put("conf3", "value3");
		p.put("conf4", "value4");
		//添加配置信息
		
		FileOutputStream fo = new FileOutputStream("config.conf");
		//创建流对象
		
		p.store(fo, "test");
		
		fo.close();
		
	}

}
