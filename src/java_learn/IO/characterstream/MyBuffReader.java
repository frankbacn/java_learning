package java_learn.IO.characterstream;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MyBuffReader {
	/**
	 * ģ��ʵ��BufferedReader�еĹ���
	 * */
	private FileReader fr = null; //�����ַ�������
	private static int SIZE = 8192; //��������С����
	
	private char[] buff = null; //���建�������ַ������󻺳���
	
	private Character[] membuff = null; //�����ȡ�����ļ��Ļ�����
	
	private int pos = 0;
	
	/**
	 * ��ʼ�����󣬿�ָ����������С
	 * @param fr
	 * @param size
	 * @throws IOException 
	 */
	public MyBuffReader(FileReader fr, int size) throws IOException {
		super();
		this.fr = fr;
		buff = new char[size];
		readIn();
	}
	
	/**
	 * ��ʼ������ʹ��Ĭ�ϻ�������С
	 * @param fr
	 * @throws IOException 
	 */
	public MyBuffReader(FileReader fr) throws IOException {
		super();
		this.fr = fr;
		buff = new char[SIZE];
		readIn();
	}
	
	/**
	 * �����ʼ���ͽ�Ҫ��ȡ���ļ�װ���ڴ��еĻ�������
	 * @throws IOException
	 */
	private void readIn() throws IOException{
		int len = 0;
		ArrayList<Character> al = new ArrayList<Character>();
		while((len = fr.read(buff))!=-1){
			for(int x = 0;x<=len;x++){
				al.add(buff[x]);
			}
		}
		al.toArray(membuff);
	}
	
	/**
	 * һ�ζ�ȡһ���ַ�
	 */
	public int read(){
		if(pos!=membuff.length){
			int ch = (char)membuff[pos];
			pos++;
			return ch;
		}
		return -1;
	}
	
	/**
	 * һ�ζ�ȡһ���ַ������ض�ȡ�ĸ���
	 * @param chs �������贫��һ�����飬��ȡһ��֪������װ�����ļ�����
	 * @return ���ض�ȡ���ַ�����
	 */
	public int read(char[] chs){
		if(pos!=membuff.length){
			int count = 0;
			for(;pos<chs.length;pos++){
				chs[count] = membuff[pos];
				count++;
			}
			return count;
		}
		return -1;
	}
	
	/**
	 * һ�ζ�ȡһ��
	 */
	public String readline(){
		if(pos!=membuff.length){
			StringBuilder b = new StringBuilder(); //����һ���ַ������������ڷ��ؽ��
			while(membuff[pos]!='\r'||membuff[pos]!='\n'){ //ѭ����ȡ���������ַ����������з�����
				b.append(membuff[pos]); //����ȡ�����ַ������ַ�����������
				pos++; //ָ������ƶ�
			}
			if(membuff[pos]=='\r')
				pos += 2; //����ָ��λ�ã���Win����������ƶ�����λ�ã�������һ�п�ʼ
			if(membuff[pos]=='\n')
				pos++; //����ָ��λ�ã���Unix����������ƶ�һ��λ�ã�������һ�п�ʼ
			return b.toString();
		}
		return null; //��������ȡ��ĩβ���ؿ�
	}
	

}
