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
	 * �޸������ļ��е�ĳ�����Բ�����
	 * @throws IOException 
	 */
	private static void setValue() throws IOException {
		
		File cf = new File("config.conf");
		//�������ļ���װ�ɶ���
		if(!cf.exists()){//�ж��ļ��Ƿ���ڣ�����������򴴽����ļ�
			System.out.println("true");
			cf.createNewFile();			
			demo();//��ʼ���ļ�����
		}		
		FileReader fr = new FileReader(cf);
		//������ȡ��		
		Properties p = new Properties();
		//��������
		p.load(fr);
		//�����ļ������ݵ�������
		p.setProperty("conf1", "new value");
		//�޸�ĳ�����Ե�ֵ
		p.list(System.out);
		//��ʾ�޸Ľ��
		FileWriter fw =  new FileWriter(cf);
		//����д����,��Ϊ�������ļ���ͬ������Ҫ�ڴ洢ǰ�ٴ���д����������Ḳ���ļ�����
		p.store(fw, "change value");
		//������
		fr.close();
		fw.close();
	}
	
	/**
	 * ģ��Properties�����load����
	 * ��ȡ�ļ��е���Ϣ�����ص�������
	 * @throws IOException
	 */
	private static void myload() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("config.conf"));
		//����������
		Properties p = new Properties();
		//�������϶���
		String line = null;
		//�����ȡ�е���ʱ����
		while((line = br.readLine())!=null){
			if(line.startsWith("#")) //�ж����Ƿ�Ϊע��
				continue;
			String[] configs = line.split("=");
			//�ԵȺŽ��������ݷָ�Ϊ�����ļ�ֵ����Ϣ��ʱ�洢
			p.put(configs[0], configs[1]);
			/*
			 * ����ʱ�洢�ļ�ֵ����Ϣ�洢��������
			 * ���ǵ�һ��Ԫ�أ��Ǳ�Ϊ0
			 * ֵ�ǵڶ���Ԫ�أ��Ǳ�Ϊ1
			 */
			
		}
		p.list(System.out);
		//��ʾ�����нṹ
		br.close();
	}

	private static void demo2() throws IOException {
		Properties p = new Properties();
		//�������Լ��϶���
		FileReader fr = new FileReader("config.conf");
		//������ȡ��
		p.load(fr);
		//���ļ��н���Ϣ���ص��ڴ�
		Set<String> keys = p.stringPropertyNames();
		//��ȡ�����е����м�
		for(String key:keys){ //ѭ����ȡ��ֵ����Ϣ
			String value = p.getProperty(key);
			System.out.println(key+":"+value);
		}
	}

	public static void demo() throws IOException {
		
		Properties p = new Properties();
		//����Properties����
		p.put("conf1", "value1");
		p.put("conf2", "value2");
		p.put("conf3", "value3");
		p.put("conf4", "value4");
		//���������Ϣ
		
		FileOutputStream fo = new FileOutputStream("config.conf");
		//����������
		
		p.store(fo, "test");
		
		fo.close();
		
	}

}
