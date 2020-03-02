package java_learn.IO.characterstream;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharacterStreamDemo {

	public static void main(String[] args) {

		/*
		 * ����C���ı��ļ���D��
		 * 
		 */
		FileReader fr = null;
		FileWriter fw = null;
		//���������ַ�������
		char[] buf = new char[8192];
		//������ȡ��������
		int len = 0;
		//������ȡ��ÿ�εļ�����
		try {
			fw = new FileWriter("F:\\java learn\\mutex.txt");
			fr = new FileReader("F:\\java learn\\java_base_learn\\mutex.log");
			//��ʼ�������ַ������󣬲������ļ�
			while((len = fr.read(buf))!=-1) {
				//ѭ����ȡ�ļ����ݵ�������
				fw.write(new String(buf,0,len));
				//���������е�����תΪ�ַ���ͨ���ַ������д���ļ�������
				fw.flush();
				//ˢ�»�����
			}
		}catch(IOException e){
			System.out.println(e);
		}finally {
			//�ر���Դ
			if(fr!=null)
				try {
					fr.close();
				}catch(IOException e){
					
				}
			if(fw!=null)
				try {
					fw.close();
				}catch(IOException e){
					
				}
		}
	}

}