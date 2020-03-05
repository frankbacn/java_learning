package java_learn.IO.bytestream;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class RunTimesCountDemo {
	/**
	 * �������д�����������
	 * ���������д����ﵽ�޶���Ͳ��������������
	 * @param args
	 */
	private static File CONFIG_FILE = new File("count.conf"); //����һ�������ļ�����
	private int count; //���������
	private Properties p = new Properties(); //�����������Լ���
	public static void main(String[] args) {
		RunTimesCountDemo rd = new RunTimesCountDemo();
		//�������ж���
		rd.readCount();//���ö�ȡ������ȡ�������д���
		if(rd.count<5){ //�жϳ������д���
			System.out.println("����������..."+rd.count+"��");
			rd.addCount(); //���÷������ӳ������д���
		}else{ //�������д�����������ʾ
			throw new RuntimeException("�������д�������");
		}
	}
	
	/**
	 * ���Ӽ�����ֵ����ֵд�������ļ�
	 */
	private void addCount() {
		count++; //����������
		p.setProperty("RunTimes", Integer.toString(count)); //��������ֵ���浽������
		FileWriter fw = null;
		try{ //����д���������漯������Ϣ
			fw = new FileWriter(CONFIG_FILE);
			p.store(fw, "");
		}catch(IOException e){
			throw new RuntimeException("�����ļ�д��ʧ��");
		}finally{
			if(fw != null)
				try {
					fw.close();
				} catch (IOException e) {
					throw new RuntimeException("�����ļ�д��ʧ��");
				}
		}
	}
	
	/**
	 * ��ȡ��������Ϣ
	 */
	private void readCount(){
		if(!CONFIG_FILE.exists()){ //�ж������ļ��Ƿ����
			try{ //�����ļ������ھʹ��������ļ���������г�ʼ��
				CONFIG_FILE.createNewFile();
				initConfigFile(); //ִ�������ļ���ʼ��
			}catch(IOException e){
				throw new RuntimeException("�����ļ�����ʧ��");
			}
		}
		FileReader fr = null;
		try{ //��ȡ�����ļ�
			fr = new FileReader(CONFIG_FILE);
			p.load(fr);
			count = Integer.parseInt(p.getProperty("RunTimes")); //���������д������浽���������
		}catch(IOException e){
			throw new RuntimeException("�����ļ���ȡʧ��");
		}finally{
			if(fr != null)
				try{
					fr.close();
				}catch(IOException e){
					throw new RuntimeException("�����ļ���ȡʧ��");
				}				
		}
		
		
	}
	/**
	 * ��ʼ�������ļ�
	 * @throws IOException
	 */
	private void initConfigFile() throws IOException {
		
		
		FileWriter fw = null;
		try{ //���������󲢽���ʼ������д�뵽�����ļ���
			fw = new FileWriter(CONFIG_FILE);
			p.setProperty("RunTimes", "0"); //�ڼ���������������Ϣ
			p.store(fw, "First time run"); //�������õ������ļ���
		}catch(IOException e){
			throw new IOException("�����ļ�д��ʧ��");
		}finally{
			if(fw != null)
				fw.close();
		}
	}
	

}
