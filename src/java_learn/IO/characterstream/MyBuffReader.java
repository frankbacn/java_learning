package java_learn.IO.characterstream;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MyBuffReader {
	/**
	 * 模拟实现BufferedReader中的功能
	 * */
	private FileReader fr = null; //定义字符流对象
	private static int SIZE = 8192; //缓冲区大小常量
	
	private char[] buff = null; //定义缓冲区，字符流对象缓冲区
	
	private Character[] membuff = null; //定义读取整个文件的缓冲区
	
	private int pos = 0;
	
	/**
	 * 初始化对象，可指定缓冲区大小
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
	 * 初始化对象，使用默认缓冲区大小
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
	 * 对象初始化就将要读取的文件装入内存中的缓冲区中
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
	 * 一次读取一个字符
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
	 * 一次读取一组字符并返回读取的个数
	 * @param chs 调用者需传入一个数组，读取一次知道数组装满或文件结束
	 * @return 返回读取的字符个数
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
	 * 一次读取一行
	 */
	public String readline(){
		if(pos!=membuff.length){
			StringBuilder b = new StringBuilder(); //定义一个字符串缓冲区用于返回结果
			while(membuff[pos]!='\r'||membuff[pos]!='\n'){ //循环读取缓冲区中字符，遇到换行符结束
				b.append(membuff[pos]); //将读取除的字符填入字符串缓冲区中
				pos++; //指针向后移动
			}
			if(membuff[pos]=='\r')
				pos += 2; //调整指针位置，在Win环境中向后移动两个位置，到达下一行开始
			if(membuff[pos]=='\n')
				pos++; //调整指针位置，在Unix环境中向后移动一个位置，到达下一行开始
			return b.toString();
		}
		return null; //缓冲区读取到末尾返回空
	}
	

}
